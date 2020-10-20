package com.aprouxdev.mediumdynamiclifes.utils;


import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;


abstract class SharedPreferencesLiveData<T> extends LiveData<T> {

    private final T mDefaultValue;
    protected final SharedPreferences mSharedPreferences;
    private final String mKey;

    private SharedPreferences.OnSharedPreferenceChangeListener mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if(key.equals(mKey)) {
                setValue(getValueFromPreferences(key, mDefaultValue));
            }
        }
    };


    abstract T getValueFromPreferences(String key, T defaultValue);

    public SharedPreferencesLiveData(SharedPreferences preferences, String key, T defaultValue){
        mSharedPreferences = preferences;
        mKey = key;
        mDefaultValue = defaultValue;
    }

    @Override
    protected void onActive() {
        setValue(getValueFromPreferences(mKey, mDefaultValue));
        mSharedPreferences.registerOnSharedPreferenceChangeListener(mListener);
    }

    @Override
    protected void onInactive() {
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(mListener);
    }


}

