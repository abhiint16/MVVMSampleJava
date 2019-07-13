package com.example.jetpacksample.views.model;

import androidx.lifecycle.ViewModelProvider;

import com.example.jetpacksample.datamanager.DataManager;
import com.example.jetpacksample.utils.ViewModelProviderFactory;
import com.example.jetpacksample.views.viewmodel.HomeActivityViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Here we will provide dependency for HomeActivity.
 * We will provide ViewModel and ViewModelProvider.
 * Same kinda Module will be made for fragments too.
 * In case any Activity has a fragment inside then we don't need to provide ViewModelProvider
 * in the Activity's module
 */
@Module
public class HomeActivityModule {

    @Provides
    public HomeActivityViewModel providesHomeActivityViewModel(DataManager dataManager) {
        return new HomeActivityViewModel(dataManager);
    }

    @Provides
    public ViewModelProvider.Factory providesFactory(HomeActivityViewModel homeActivityViewModel) {
        return new ViewModelProviderFactory(homeActivityViewModel);

    }
}
