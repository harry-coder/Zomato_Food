package com.lybrate.zomato.Component;



import com.lybrate.zomato.MainActivity;
import com.lybrate.zomato.Modules.DatabaseModule;
import com.lybrate.zomato.Modules.RetrofitModule;
import com.lybrate.zomato.Repository.CuisineRepository;

import dagger.Component;

@Component(modules = {RetrofitModule.class, DatabaseModule.class})
public interface AppComponent {

    public void inject(MainActivity mainActivity);

    public void inject(CuisineRepository coordinateRepositoty);
}
