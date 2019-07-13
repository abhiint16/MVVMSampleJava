package com.example.jetpacksample.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    @Inject
    Context context;

    @Provides
    @Singleton
    public Context providesApplicationContext(Application application) {
        return application;
    }

}
