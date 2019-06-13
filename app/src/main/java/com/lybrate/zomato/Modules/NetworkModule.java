package com.lybrate.zomato.Modules;

import android.content.Context;

import com.lybrate.zomato.Scope.ServiceScope;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


@Module(includes = {ContextModule.class})
public abstract class NetworkModule {


    @ServiceScope
    @Provides
    public static OkHttpClient getOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder ( ).addInterceptor ( new Interceptor ( ) {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request ( );

                //   System.out.println("This is request body " + originalRequest.);
           /* HttpUrl originalUrl=originalRequest.url();

            HttpUrl url=originalUrl.newBuilder().addQueryParameter("abc","abc").build();

            Request request=originalRequest.newBuilder().url(url).build();*/

                return chain.proceed ( originalRequest );

            }
        } ).connectTimeout ( 1, TimeUnit.MINUTES )
                .readTimeout ( 30, TimeUnit.SECONDS )
                .writeTimeout ( 15, TimeUnit.SECONDS ).addInterceptor ( interceptor ).build ( );
    }

    @ServiceScope
    @Provides
    public static Cache getCache(Context context) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache ( Objects.requireNonNull ( context != null ? context.getCacheDir ( ) : null ), cacheSize );

    }

    @ServiceScope
    @Provides
    public static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor ( ).setLevel ( HttpLoggingInterceptor.Level.BODY );
    }

    @ServiceScope
    @Provides
    public static Picasso picasso(Context context) {
        return new Picasso.Builder ( context ).build ( );
    }


}
