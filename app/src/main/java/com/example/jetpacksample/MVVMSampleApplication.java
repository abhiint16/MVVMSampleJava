package com.example.jetpacksample;

import android.app.Activity;
import android.app.Application;

import com.example.jetpacksample.di.AppComponent;
import com.example.jetpacksample.di.DaggerAppComponent;
import com.example.jetpacksample.di.modules.DataManagerModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MVVMSampleApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder().application(this)
                .build();
        appComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
