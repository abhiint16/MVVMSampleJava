package com.example.jetpacksample.views.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jetpacksample.datamanager.DataManager;

public class HomeActivityViewModel extends ViewModel {
    DataManager dataManager;

    MutableLiveData<Boolean> mutableLiveData = new MutableLiveData();

    public HomeActivityViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void testItem() {
        mutableLiveData.setValue(true);
    }

    public LiveData<Boolean> observeForLiveData() {
        return mutableLiveData;
    }
}
