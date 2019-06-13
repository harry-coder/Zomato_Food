package com.lybrate.zomato.RetrofitModelClasses;

import java.util.List;

public class RestaurantsItem {

    private Restaurant restaurant;

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return
                "RestaurantsItem{" +
                        "restaurant = '" + restaurant + '\'' +
                        "}";
    }


}
