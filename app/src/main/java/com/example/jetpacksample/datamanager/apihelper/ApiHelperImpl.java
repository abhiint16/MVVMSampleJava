package com.example.jetpacksample.datamanager.apihelper;

import javax.inject.Inject;

/**
 * This class acts as a one point of source for all the APIs. All the API calls will go through
 * this class.
 */
public class ApiHelperImpl implements ApiHelper {

    ApiService apiService;

    @Inject
    public ApiHelperImpl(ApiService apiService) {
        this.apiService = apiService;
    }
}
