package com.lybrate.zomato.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.lybrate.zomato.Repository.CuisineRepository;
import com.lybrate.zomato.RetrofitResponseWrapper.CuisineResponseWrapper;

import java.io.IOException;


public class CuisineViewModel extends AndroidViewModel {

    CuisineRepository cuisineRepository;


    public CuisineViewModel(@NonNull Application application) {
        super ( application );

        cuisineRepository = new CuisineRepository ( application);

    }

    public LiveData <CuisineResponseWrapper> getCuisineFromServer(String keyword) throws IOException {

        return cuisineRepository.getZomatoCuisine (keyword);
    }
}
