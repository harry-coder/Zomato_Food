package com.lybrate.zomato.Services;

import com.lybrate.zomato.RetrofitModelClasses.CuisinePojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CuisineRetrofitService {


    @GET("search")
    Call <CuisinePojo> getZomatoCuisine(@Query ( "q" )String query, @Query ( "count" )int count, @Header ( "user-key" )String key);


}
