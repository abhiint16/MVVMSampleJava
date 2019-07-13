package com.example.jetpacksample.di;

import android.app.Application;

import com.example.jetpacksample.di.builder.ViewBuilderModule;
import com.example.jetpacksample.di.modules.ContextModule;
import com.example.jetpacksample.di.modules.DataManagerModule;
import com.example.jetpacksample.di.modules.NetworkModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {DataManagerModule.class, NetworkModule.class, ViewBuilderModule.class
        , ContextModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder application(Application application);

    }
}
