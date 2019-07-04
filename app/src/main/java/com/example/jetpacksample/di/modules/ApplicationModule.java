package com.example.jetpacksample.di.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.jetpacksample.datamanager.DataManager;
import com.example.jetpacksample.datamanager.DataManagerImpl;
import com.example.jetpacksample.datamanager.apihelper.ApiHelper;
import com.example.jetpacksample.datamanager.apihelper.ApiHelperImpl;
import com.example.jetpacksample.datamanager.dbhelper.DBHelper;
import com.example.jetpacksample.datamanager.dbhelper.DBHelperImpl;
import com.example.jetpacksample.datamanager.prefhelper.PreferenceHelper;
import com.example.jetpacksample.datamanager.prefhelper.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    public Context providesApplicationContext(Application application) {
        return application;
    }

    /**
     * Provides Data Manager instance
     *
     * @param dataManager
     * @return DataManager {@link com.example.jetpacksample.datamanager.DataManager}
     */
    @Provides
    @Singleton
    DataManager providesDataManager(DataManagerImpl dataManager) {
        return dataManager;
    }

    /**
     * Provides ApiHelper instance
     *
     * @param apiHelper
     * @return ApiHelper {@link com.example.jetpacksample.datamanager.apihelper.ApiHelper}
     */
    @Provides
    @Singleton
    ApiHelper providesApiHelper(ApiHelperImpl apiHelper) {
        return apiHelper;
    }

    /**
     * Provides DB Helper instance
     *
     * @param dbHelper
     * @return NLearnDBHelper {@link DBHelper}
     */
    @Provides
    @Singleton
    DBHelper providesDBHelper(DBHelperImpl dbHelper) {
        return dbHelper;
    }

    /**
     * Provides Preference Helper
     *
     * @param preferenceHelper
     * @return Preference Helper {@link com.example.jetpacksample.datamanager.prefhelper.PreferenceHelper}
     */
    @Provides
    @Singleton
    PreferenceHelper providesPreferenceHelper(PreferenceHelperImpl preferenceHelper) {
        return preferenceHelper;
    }

    @Provides
    @Singleton
    Context providesContext(Application application) {
        return application;
    }

}
