package com.aprouxdev.mediumdynamiclifes.utils;

import android.content.SharedPreferences;

public class SharedPreferenceIntegerLiveData extends SharedPreferencesLiveData<Integer> {


    public SharedPreferenceIntegerLiveData(SharedPreferences preferences, String key, Integer defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    Integer getValueFromPreferences(String key, Integer defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }
}
