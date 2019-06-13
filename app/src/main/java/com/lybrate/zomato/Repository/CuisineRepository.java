package com.lybrate.zomato.Repository;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lybrate.zomato.Component.AppComponent;
import com.lybrate.zomato.MyApplication;
import com.lybrate.zomato.RetrofitModelClasses.CuisinePojo;
import com.lybrate.zomato.RetrofitModelClasses.Restaurant;
import com.lybrate.zomato.RetrofitModelClasses.RestaurantsItem;
import com.lybrate.zomato.RetrofitResponseWrapper.CuisineResponseWrapper;
import com.lybrate.zomato.Services.CuisineRetrofitService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CuisineRepository {
    private final String API_KEY = "54f8b461380bacc9ca6097496f545a95";
    private Context context;


    AppComponent appComponent;


    @Inject
    CuisineRetrofitService cuisineRetrofitService;

    public CuisineRepository(Context context) {
        this.context = context;
        appComponent = MyApplication.appComponent;
        appComponent.inject ( this );


    }


    //This method uses CuisineResponseWrapper to wrap the response return by service so that it is available to the view.
    public LiveData <CuisineResponseWrapper> getZomatoCuisine(String keyword) throws IOException {

        final MutableLiveData <CuisineResponseWrapper> liveData = new MutableLiveData <> ( );
        cuisineRetrofitService.getZomatoCuisine ( keyword, 20, API_KEY ).enqueue ( new Callback <CuisinePojo> ( ) {
            @Override
            public void onResponse(Call <CuisinePojo> call, Response <CuisinePojo> response) {
                System.out.println ( "This is the response " + response.body ( ) );

                HashSet <String> cuisineHeaderSet = new HashSet <> ( );
                for (int i = 0; i < response.body ( ).getRestaurants ( ).size ( ); i++) {
                    RestaurantsItem restaurantsItem = response.body ( ).getRestaurants ( ).get ( i );
                    cuisineHeaderSet.add ( restaurantsItem.getRestaurant ( ).getCuisines ( ) );

                }

                ArrayList <String> headerList = new ArrayList <> ( cuisineHeaderSet );


                for (String header : cuisineHeaderSet) {

                    System.out.println ( "Header " + header );
                }


                if (response.isSuccessful ( )) {
                    liveData.setValue ( new CuisineResponseWrapper ( response.body ( ).getRestaurants ( ), headerList ) );

                } else
                    liveData.setValue ( new CuisineResponseWrapper ( response.code ( ) ) );
            }

            @Override
            public void onFailure(Call <CuisinePojo> call, Throwable t) {

                liveData.setValue ( new CuisineResponseWrapper ( t ) );
            }
        } );


        return liveData;

    }

    public class sortCuisine implements Comparator <Restaurant> {


        @Override
        public int compare(Restaurant o1, Restaurant o2) {

            if (o1.getCuisines ( ).contains ( o2.getCuisines ( ) )) {
                return 1;
            } else if (o1.getCuisines ( ).equalsIgnoreCase ( o2.getCuisines ( ) )) {

                return 1;
            } else {
                return -1;
            }
        }
    }


}
