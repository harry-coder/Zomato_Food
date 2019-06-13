package com.lybrate.zomato.Modules;

import android.content.Context;


import com.lybrate.zomato.Scope.ServiceScope;

import dagger.Module;
import dagger.Provides;


@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ServiceScope
    @Provides
    public Context getContex() {
        return context;
    }

}