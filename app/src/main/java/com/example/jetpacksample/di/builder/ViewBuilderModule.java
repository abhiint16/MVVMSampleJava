package com.example.jetpacksample.di.builder;

import com.example.jetpacksample.views.HomeActivity;
import com.example.jetpacksample.views.model.HomeActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * this abstract class binds basic dependencies to Activity level di and
 * to Fragment level dependency provider from where dependecies goes deeper into
 * Fragment level di
 */
@Module
public abstract class ViewBuilderModule {

    @ContributesAndroidInjector(modules = {HomeActivityModule.class})
    abstract HomeActivity homeActivity();
}
