package com.example.jetpacksample.di;

import dagger.Component;

@Component(modules = {ApplicationModule.class, NetworkModule.class, ViewBuilderModule.class})
public interface AppComponent {
}
