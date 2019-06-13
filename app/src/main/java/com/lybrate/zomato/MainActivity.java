package com.lybrate.zomato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.lybrate.zomato.Component.AppComponent;
import com.lybrate.zomato.RetrofitModelClasses.Location;
import com.lybrate.zomato.RetrofitModelClasses.Restaurant;
import com.lybrate.zomato.RetrofitModelClasses.RestaurantsItem;
import com.lybrate.zomato.RetrofitModelClasses.UserRating;
import com.lybrate.zomato.RetrofitResponseWrapper.CuisineResponseWrapper;
import com.lybrate.zomato.ViewModel.CuisineViewModel;
import com.lybrate.zomato.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private CuisineViewModel cuisineViewModel;

    private ActivityMainBinding activityMainBinding;

    private RecyclerView rv_cuisineContainer;

    private HeaderAdapter headerAdapter;

    private ShimmerFrameLayout shimmerFrameLayout;
    private Button bt_search;

    private AppComponent appComponent;

    @Inject
     Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        activityMainBinding = DataBindingUtil.setContentView ( this, R.layout.activity_main );
        cuisineViewModel = ViewModelProviders.of ( this ).get ( CuisineViewModel.class );

        appComponent = MyApplication.appComponent;
        System.out.println ( );
        appComponent.inject ( this );

        rv_cuisineContainer = activityMainBinding.rvCuisineContainer;
        rv_cuisineContainer.setLayoutManager ( new LinearLayoutManager ( this ) );


        headerAdapter = new HeaderAdapter ( this );
        rv_cuisineContainer.setAdapter ( headerAdapter );

        shimmerFrameLayout = activityMainBinding.shimmerViewContainer;
        bt_search = activityMainBinding.btSearch;

    }

    //OnClick for search button
    public void getCuisine(View view) {

        String keyword = activityMainBinding.etSearchItems.getText ( ).toString ( );
        System.out.println ( "Keyword " + keyword );
        if (!TextUtils.isEmpty ( keyword )) {
            searchCuisine ( keyword );
            bt_search.setEnabled ( false );
            rv_cuisineContainer.setVisibility ( View.GONE );
            shimmerFrameLayout.setVisibility ( View.VISIBLE );
            shimmerFrameLayout.startShimmer ( );

        } else {
            Toast.makeText ( this, "Please provide keyword", Toast.LENGTH_SHORT ).show ( );
        }


    }

    //Returns the Cuisines from Api
    public void searchCuisine(String keyword) {
        try {
            cuisineViewModel.getCuisineFromServer ( keyword ).observe ( this, new Observer <CuisineResponseWrapper> ( ) {
                @Override
                public void onChanged(CuisineResponseWrapper cuisineResponseWrapper) {


                    if (cuisineResponseWrapper.getThrowable ( ) == null && cuisineResponseWrapper.getResponseCode ( ) == 0) {
                        rv_cuisineContainer.setVisibility ( View.VISIBLE );
                        shimmerFrameLayout.stopShimmer ( );
                        shimmerFrameLayout.setVisibility ( View.GONE );

                        headerAdapter.setSource ( cuisineResponseWrapper.getRestaurantsItemList ( ), cuisineResponseWrapper.getHeaderList ( ) );

                        bt_search.setEnabled ( true );


                    }

                }
            } );
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }


    //Adapter to display headers in recyclerview..
    public class HeaderAdapter extends RecyclerView.Adapter <HeaderAdapter.HeaderHolder> {

        private List <RestaurantsItem> cuisineList = new ArrayList <> ( );

        private ArrayList <String> headerList = new ArrayList <> ( );
        LayoutInflater inflater;
        Context context;

        HeaderAdapter(Context context) {
            inflater = LayoutInflater.from ( context );

            this.context = context;
        }

        @Override
        public HeaderAdapter.HeaderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate ( R.layout.header_single_item, parent, false );

            return new HeaderAdapter.HeaderHolder ( view );
        }

        @Override
        public void onBindViewHolder(HeaderAdapter.HeaderHolder holder, int position) {


            String cuisineType = headerList.get ( position );
            holder.tv_header.setText ( cuisineType );

            ArrayList <Restaurant> groupedByCuisineList = new ArrayList <> ( );

            for (int i = 0; i < cuisineList.size ( ); i++) {
                RestaurantsItem currentItem = cuisineList.get ( i );
                Restaurant currentRestaurantItem = currentItem.getRestaurant ( );

                if (cuisineType.equalsIgnoreCase ( currentRestaurantItem.getCuisines ( ) )) {

                    groupedByCuisineList.add ( currentRestaurantItem );
                }
            }

            holder.cuisineAdapter.setSource ( groupedByCuisineList );

        }

        @Override
        public int getItemCount() {

            return headerList.size ( );
        }

        void setSource(List <RestaurantsItem> list, ArrayList <String> headerList) {
            if (list.size ( ) != 0) {
                this.cuisineList = list;

                this.headerList = headerList;
                notifyItemRangeRemoved ( 0, cuisineList.size ( ) );

                notifyDataSetChanged ( );
            }

        }

        class HeaderHolder extends RecyclerView.ViewHolder {

            TextView tv_header;
            RecyclerView rv_cuisineDetailsContainer;
//            CardView cv_taskCard;

            private CuisineAdapter cuisineAdapter;

            public HeaderHolder(View itemView) {
                super ( itemView );

                tv_header = itemView.findViewById ( R.id.tv_header );
                rv_cuisineDetailsContainer = itemView.findViewById ( R.id.rv_cuisineContainerMaster );
                rv_cuisineDetailsContainer.setLayoutManager ( new LinearLayoutManager ( context ) );
                cuisineAdapter = new CuisineAdapter ( context );
                rv_cuisineDetailsContainer.setAdapter ( cuisineAdapter );


            }
        }


    }


    //Adapter to display cuisines under different headers.
    public class CuisineAdapter extends RecyclerView.Adapter <CuisineAdapter.CuisineHolder> {


        private LayoutInflater inflater;

        private List <Restaurant> cuisineList = new ArrayList <> ( );

        CuisineAdapter(Context context) {
            inflater = LayoutInflater.from ( context );

        }

        @Override
        public CuisineAdapter.CuisineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate ( R.layout.cuisine_single_item, parent, false );

            return new CuisineAdapter.CuisineHolder ( view );
        }

        @Override
        public void onBindViewHolder(CuisineAdapter.CuisineHolder holder, int position) {


            Restaurant restaurant = cuisineList.get ( position );


            Location location = restaurant.getLocation ( );

            UserRating userRating = restaurant.getUserRating ( );

            holder.tv_cuisineName.setText ( restaurant.getName ( ) );
            holder.tv_city.setText ( location.getCity ( ) );
            holder.tv_place.setText ( location.getLocality ( ) );
            holder.tv_price.setText ( (restaurant.getAverageCostForTwo ( ) + "Per Person") );
            holder.tv_rating.setText ( userRating.getAggregateRating ( ) );

            GradientDrawable drawable = (GradientDrawable) holder.tv_rating.getBackground ( );
            drawable.setColor ( Color.parseColor ( "#" + userRating.getRatingColor ( ) ) );


            String url = restaurant.getThumb ( );


            setImageFromPicasso ( holder.im_cuisineImage, url );


        }


        public void setImageFromPicasso(ImageView imageView, String url) {

            if (!TextUtils.isEmpty ( url )) {
                picasso
                        .load ( url ).fit ( ).centerCrop ( )
                        // .placeholder(R.drawable.palm) //this is optional the image to display while the url image is downloading
                        .error ( R.drawable.ic_launcher_background )
                        .into ( imageView );//this is also optional if some error has occurred in downloading the image this image would be displayed

            }
        }

        @Override
        public int getItemCount() {

            return cuisineList.size ( );
        }

        void setSource(List <Restaurant> list) {
            if (list.size ( ) != 0) {
                this.cuisineList = list;

                notifyItemRangeRemoved ( 0, cuisineList.size ( ) );

                notifyDataSetChanged ( );
            }

        }

        class CuisineHolder extends RecyclerView.ViewHolder {

            private TextView tv_cuisineName, tv_city, tv_price, tv_place, tv_rating;
            private ImageView im_cuisineImage;
//            CardView cv_taskCard;


            public CuisineHolder(View itemView) {
                super ( itemView );

                tv_city = itemView.findViewById ( R.id.tv_city );
                tv_cuisineName = itemView.findViewById ( R.id.tv_cuisineName );
                tv_place = itemView.findViewById ( R.id.tv_place );
                tv_price = itemView.findViewById ( R.id.tv_price );
                tv_rating = itemView.findViewById ( R.id.tv_rating );
                im_cuisineImage = itemView.findViewById ( R.id.im_cuisineImage );

            }
        }


    }
}


