package com.lybrate.zomato.Modules;


import com.lybrate.zomato.Scope.ServiceScope;
import com.lybrate.zomato.Services.CuisineRetrofitService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {NetworkModule.class})
public abstract class RetrofitModule {

    private static final String serviceUrl="https://developers.zomato.com/api/v2.1/";

    @ServiceScope
    @Provides
    public static Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder ( ).baseUrl (serviceUrl)
                .addConverterFactory ( GsonConverterFactory.create ( ) ).client ( okHttpClient ).build ( );
    }

    /*@ServiceScope
    @Provides
    public <T> T userCoordinateService(Retrofit retrofit,Class<T> request) {
        return retrofit.create ( request );

    }*/

    @ServiceScope
    @Provides
    public static CuisineRetrofitService userCoordinateService(Retrofit retrofit) {
        return retrofit.create ( CuisineRetrofitService.class );

    }



}
