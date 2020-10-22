package com.aprouxdev.mediumdynamiclifes.viewmodel;
/*
 * Created by antoine on 20.10.20.
 */

import android.content.SharedPreferences;
import android.os.CountDownTimer;

import androidx.lifecycle.ViewModel;

import com.aprouxdev.mediumdynamiclifes.data.DataManager;
import com.aprouxdev.mediumdynamiclifes.utils.Constants;
import com.aprouxdev.mediumdynamiclifes.utils.SharedPreferenceIntegerLiveData;

public class DynamicLifeViewModel extends ViewModel {
    // STATIC VARS
    // UI VARS


    // DATA VARS
    private SharedPreferenceIntegerLiveData mLifeNumberLiveData;
    protected long mTimeLeftInMillis;
    protected Boolean mTimerRunning;
    protected long mEndTime;
    protected CountDownTimer mCountDownTimer;



    public DynamicLifeViewModel() {

    }

    public SharedPreferenceIntegerLiveData getLifeNumberLiveData() {
        return mLifeNumberLiveData;
    }


    public void setLifeNumberLiveData() {
        SharedPreferences pref = DataManager.getInstance().getPreferences();
        mLifeNumberLiveData = new SharedPreferenceIntegerLiveData(pref, Constants.PREF_USER_LIFE, Constants.LIFE_MAX_NUMBER);
    }

    public void startTimer(long lastUpdate) {
        // Setup end time : current time + 3 min
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    public void saveTimerInfo(){

    }
}
