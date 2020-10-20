package com.aprouxdev.mediumdynamiclifes.ui.activity;
/*
 * Created by antoine on 20.10.20.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aprouxdev.mediumdynamiclifes.R;
import com.aprouxdev.mediumdynamiclifes.data.DataManager;
import com.aprouxdev.mediumdynamiclifes.ui.fragment.ToolbarFragment;

import java.util.Calendar;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        setupToolbar();
    }

    private void setupToolbar() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ToolbarFragment toolbarFragment = new ToolbarFragment();
        fragmentTransaction.add(R.id.toolbar_fragment, toolbarFragment);
        fragmentTransaction.commit();
    }


    public void useLifeButtonCLicked(View view) {
        int lifeNumber = DataManager.getInstance().getLifeNumber();
        long currentTime = Calendar.getInstance().getTimeInMillis();
        DataManager.getInstance().saveLifeData(lifeNumber - 1, currentTime);
    }

    public void goToMainActivityClicked(View view) {
        startActivity(new Intent(NextActivity.this, MainActivity.class));
    }
}
