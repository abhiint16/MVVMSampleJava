package com.example.jetpacksample.di;

import android.app.Application;

import com.example.jetpacksample.MVVMSampleApplication;
import com.example.jetpacksample.di.builder.ViewBuilderModule;
import com.example.jetpacksample.di.modules.ContextModule;
import com.example.jetpacksample.di.modules.DataManagerModule;
import com.example.jetpacksample.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {DataManagerModule.class, NetworkModule.class, ViewBuilderModule.class
        , ContextModule.class})
public interface AppComponent {

    void inject(MVVMSampleApplication MVVMSampleApplication);

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder application(Application application);

    }
}
