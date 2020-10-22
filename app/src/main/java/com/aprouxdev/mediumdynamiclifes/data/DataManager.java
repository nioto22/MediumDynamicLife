package com.aprouxdev.mediumdynamiclifes.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.aprouxdev.mediumdynamiclifes.utils.Constants;

import java.util.Calendar;
import java.util.HashMap;

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

    public void saveLifeData(int lifeNumber, long remainTime) {
        mPreferences.edit()
                .putInt(Constants.PREF_USER_LIFE, lifeNumber)
                .putLong(Constants.PREF_LIFE_REMAIN_TIME, remainTime)
                .apply();
    }
    public HashMap<String, Object> getLifeData() {
        HashMap<String, Object> result = new HashMap<>();
        int lifePosition = mPreferences.getInt(Constants.PREF_USER_LIFE, Constants.LIFE_MAX_NUMBER);
        long currentTime = Calendar.getInstance().getTimeInMillis();
        long remainTime = mPreferences.getLong(Constants.PREF_LIFE_REMAIN_TIME, Constants.TIMES_UP_UNTIL_NEW_LIFE);
        result.put(Constants.LIFE_POSITION, lifePosition);
        result.put(Constants.LAST_UPDATE, remainTime);
        return result;
    }

    public SharedPreferences getPreferences() {
        return mPreferences;
    }

    public int getLifeNumber() {
        return mPreferences.getInt(Constants.PREF_USER_LIFE, Constants.LIFE_MAX_NUMBER);
    }
    public long getRemainingTime() {
        return mPreferences.getLong(Constants.PREF_LIFE_REMAIN_TIME, Constants.TIMES_UP_UNTIL_NEW_LIFE);
    }
}
