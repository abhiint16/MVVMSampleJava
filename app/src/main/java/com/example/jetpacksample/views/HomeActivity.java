package com.example.jetpacksample.views;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.jetpacksample.R;
import com.example.jetpacksample.databinding.ActivityHomeBinding;
import com.example.jetpacksample.views.viewmodel.HomeActivityViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class HomeActivity extends AppCompatActivity {
    @Inject
    ViewModelProvider.Factory factory;

    HomeActivityViewModel homeActivityViewModel;

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        homeActivityViewModel = ViewModelProviders.of(this, factory).get(HomeActivityViewModel.class);
        homeActivityViewModel.testItem();
        initObserver();
    }

    private void initObserver() {
        homeActivityViewModel.observeForLiveData().observe(this, aBoolean -> {
            Toast.makeText(this, "Live Data Observed", Toast.LENGTH_LONG).show();
        });
    }
}
