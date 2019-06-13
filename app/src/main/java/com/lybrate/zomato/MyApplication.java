package com.lybrate.zomato;

import android.app.Application;

import com.lybrate.zomato.Component.AppComponent;
import com.lybrate.zomato.Component.DaggerAppComponent;
import com.lybrate.zomato.Modules.ContextModule;

public class MyApplication extends Application {
     public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate ( );
        appComponent= DaggerAppComponent.builder ().contextModule ( new ContextModule ( this ) ).build ();

    }


}
