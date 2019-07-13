package com.example.jetpacksample.datamanager;

import com.example.jetpacksample.datamanager.apihelper.ApiHelper;
import com.example.jetpacksample.datamanager.dbhelper.DBHelper;
import com.example.jetpacksample.datamanager.prefhelper.PreferenceHelper;

import javax.inject.Inject;

/**
 * This class acts as single source of truth for our aplication. All the data related calls goes
 * through this class. Be it Data from APIs, DBs such as Room or SQLite, or from SharedPref,
 * everything goes from here. This class acts as **Repository** for our application.
 */
public class DataManagerImpl implements DataManager {
    ApiHelper apiHelper;
    DBHelper dbHelper;
    PreferenceHelper preferenceHelper;

    @Inject
    public DataManagerImpl(ApiHelper apiHelper, DBHelper dbHelper, PreferenceHelper preferenceHelper) {
        this.apiHelper = apiHelper;
        this.dbHelper = dbHelper;
        this.preferenceHelper = preferenceHelper;
    }
}
