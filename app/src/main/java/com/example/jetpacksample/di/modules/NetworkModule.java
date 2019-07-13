package com.example.jetpacksample.di.modules;

import android.app.Application;

import com.example.jetpacksample.BuildConfig;
import com.example.jetpacksample.di.qualifier.BaseUrl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    /**
     * The @Singleton annotation is used to declare to Dagger that the provided object is to be only
     * initialized only once during the entire lifecycle of the *Component* which uses that Module.
     *
     * @return
     */
    @Singleton
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    @BaseUrl
    @Provides
    public String providesBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    @Singleton
    Cache provideCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGsonFactory() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGson(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache,
                                     HttpLoggingInterceptor interceptor,
                                     Interceptor retryInterceptor) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addInterceptor(retryInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Interceptor providesInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                return response;
            }
        };
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(GsonConverterFactory gsonConverterFactory, OkHttpClient okHttpClient,
                             @BaseUrl String baseUrl) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

}
