package com.aprouxdev.mediumdynamiclifes.ui;

import android.app.Application;
import android.provider.ContactsContract;

import com.aprouxdev.mediumdynamiclifes.data.DataManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DataManager.setup(getApplicationContext());
    }
}
