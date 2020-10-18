package com.aprouxdev.mediumdynamiclifes.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getFragmentLayout());
    }

    // Abstract methods for children class
    public abstract int getFragmentLayout();
    public abstract void getToolbarViews();






}
