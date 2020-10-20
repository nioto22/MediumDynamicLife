package com.aprouxdev.mediumdynamiclifes.utils;
/*
 * Created by antoine on 11.08.20.
 */

import android.content.SharedPreferences;

public class SharedPreferenceBooleanLiveData extends SharedPreferencesLiveData<Boolean> {


    public SharedPreferenceBooleanLiveData(SharedPreferences preferences, String key, Boolean defaultValue) {
        super(preferences, key, defaultValue);
    }
    @Override
    Boolean getValueFromPreferences(String key, Boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }
}
