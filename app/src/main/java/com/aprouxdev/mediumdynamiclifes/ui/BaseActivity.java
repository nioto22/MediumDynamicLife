package com.aprouxdev.mediumdynamiclifes.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aprouxdev.mediumdynamiclifes.ui.fragment.ToolbarFragment;

public abstract class BaseActivity extends AppCompatActivity {

        // STATIC VARS
        private static final String TAG = "";
        // UI VARS

        // DATA VARS
    protected ToolbarFragment toolbarFragment;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getFragmentLayout());

    }

    // Abstract methods for children class
    public abstract int getFragmentLayout();
    //public abstract ToolbarFragment getToolbarFragment();






}
