package com.example.jetpacksample.di.modules;

import com.example.jetpacksample.AppConstants;
import com.example.jetpacksample.datamanager.DataManager;
import com.example.jetpacksample.datamanager.DataManagerImpl;
import com.example.jetpacksample.datamanager.apihelper.ApiHelper;
import com.example.jetpacksample.datamanager.apihelper.ApiHelperImpl;
import com.example.jetpacksample.datamanager.apihelper.ApiService;
import com.example.jetpacksample.datamanager.dbhelper.DBHelper;
import com.example.jetpacksample.datamanager.dbhelper.DBHelperImpl;
import com.example.jetpacksample.datamanager.prefhelper.PreferenceHelper;
import com.example.jetpacksample.datamanager.prefhelper.PreferenceHelperImpl;
import com.example.jetpacksample.di.qualifier.PreferenceName;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class DataManagerModule {

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
    ApiService provideAPIRetrofitInstance(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @PreferenceName
    @Provides
    String providesSharedPrefName(){
        return AppConstants.SHARED_PREFERENCE_NAME;
    }

}
