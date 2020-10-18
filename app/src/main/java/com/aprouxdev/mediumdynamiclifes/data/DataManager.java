package com.aprouxdev.mediumdynamiclifes.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.aprouxdev.mediumdynamiclifes.utils.Constants;

public class DataManager {
    private static DataManager mInstance;
    private Context mContext;
    private SharedPreferences mPreferences;


    public DataManager(Context context) {
        mContext = context;
        mPreferences = mContext.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void setup(Context context) {
        if (mInstance == null)
            mInstance = new DataManager(context.getApplicationContext());
    }

    public static DataManager getInstance() {
        if (mInstance == null)
            throw new RuntimeException("Data manager is not setup !");
        return mInstance;
    }

    public void saveLifeData(int lifeNumber, long remainingTime) {
        mPreferences.edit()
                .putInt(Constants.PREF_USER_LIFE, lifeNumber)
                .putLong(Constants.PREF_LIFE_REMAIN_TIME, remainingTime)
                .apply();
    }
}
