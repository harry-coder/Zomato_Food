package com.lybrate.zomato.Modules;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lybrate.zomato.Database.CuisineDao;
import com.lybrate.zomato.Model.CuisineEntity;
import com.lybrate.zomato.Scope.ServiceScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
@Database( entities = {CuisineEntity.class},version = 1,exportSchema = false)

public abstract class DatabaseModule extends RoomDatabase {

    public abstract CuisineDao coordinateDao();


    private static final String DB_NAME = "cuisine.db";


    @ServiceScope
    @Provides
    public static DatabaseModule getUserCoordinateDB(Context context) {

        return Room.databaseBuilder ( context, DatabaseModule.class, DB_NAME ).allowMainThreadQueries ( ).build ( );
    }
}
