package com.example.jetpacksample.datamanager.prefhelper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.jetpacksample.di.qualifier.PreferenceName;

import javax.inject.Inject;

/**
 * This class acts as a one point of source for all the SharedPreference calls.
 */
public class PreferenceHelperImpl implements PreferenceHelper {
    private Context context;
    private String prefName;
    private SharedPreferences sharedPreferences;

    @Inject
    public PreferenceHelperImpl(Context context, @PreferenceName String prefName) {
        this.context = context;
        this.prefName = prefName;
        sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }
}
