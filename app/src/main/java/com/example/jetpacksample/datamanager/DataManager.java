package com.example.jetpacksample.datamanager;

import com.example.jetpacksample.datamanager.apihelper.ApiHelper;
import com.example.jetpacksample.datamanager.dbhelper.DBHelper;
import com.example.jetpacksample.datamanager.prefhelper.PreferenceHelper;

public interface DataManager extends PreferenceHelper, DBHelper, ApiHelper {
}
