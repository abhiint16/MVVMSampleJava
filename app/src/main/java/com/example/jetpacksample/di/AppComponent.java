package com.example.jetpacksample.di;

import com.example.jetpacksample.di.builder.ViewBuilderModule;
import com.example.jetpacksample.di.modules.ApplicationModule;
import com.example.jetpacksample.di.modules.NetworkModule;

import dagger.Component;

@Component(modules = {ApplicationModule.class, NetworkModule.class, ViewBuilderModule.class})
public interface AppComponent {
}
