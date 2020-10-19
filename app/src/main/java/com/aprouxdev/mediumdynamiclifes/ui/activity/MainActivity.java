package com.aprouxdev.mediumdynamiclifes.ui.activity;

import android.os.Bundle;

import com.aprouxdev.mediumdynamiclifes.R;
import com.aprouxdev.mediumdynamiclifes.ui.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void getToolbarViews() {

    }
}
