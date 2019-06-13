package com.lybrate.zomato.RetrofitResponseWrapper;

import com.lybrate.zomato.RetrofitModelClasses.RestaurantsItem;

import java.util.ArrayList;
import java.util.List;

public class CuisineResponseWrapper {

    private List <RestaurantsItem> restaurantsItemList;
    private Throwable throwable;

   private ArrayList<String>headerList;

   public CuisineResponseWrapper(List <RestaurantsItem> restaurantsItemList, ArrayList <String> headerList){
        this.restaurantsItemList=restaurantsItemList;
        this.headerList=headerList;
    }
   public CuisineResponseWrapper(Throwable throwable){
       this.throwable=throwable;
    }
   public CuisineResponseWrapper(int responseCode){
       this.responseCode=responseCode;
    }

    public List<RestaurantsItem> getRestaurantsItemList() {
        return restaurantsItemList;
    }

    public void setRestaurantsItemList(List<RestaurantsItem> restaurantsItemList) {
        this.restaurantsItemList = restaurantsItemList;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    private int responseCode;

    public ArrayList <String> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(ArrayList <String> headerList) {
        this.headerList = headerList;
    }
}
