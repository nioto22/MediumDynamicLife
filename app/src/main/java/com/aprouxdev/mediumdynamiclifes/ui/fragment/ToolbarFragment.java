package com.aprouxdev.mediumdynamiclifes.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprouxdev.mediumdynamiclifes.R;
import com.aprouxdev.mediumdynamiclifes.data.DataManager;
import com.aprouxdev.mediumdynamiclifes.utils.Constants;
import com.aprouxdev.mediumdynamiclifes.viewmodel.DynamicLifeViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.HashMap;

public class ToolbarFragment extends Fragment {
        // STATIC VARS
        private static final String TAG = "ToolbarFragment";
        // UI VARS
        private View mContentView;
        private TextView lifeTv;
        private ImageView lifeIv;
        private TextView timerTv;
        // DATA VARS
    private DynamicLifeViewModel mViewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContentView = inflater.inflate(R.layout.toolbar_fragment, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(DynamicLifeViewModel.class);

        setupViews();
        setupUiViews();
        setupListeners();

        return mContentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    private void setupViews() {
        lifeTv = mContentView.findViewById(R.id.toolbar_fragment_life_tv);
        lifeIv = mContentView.findViewById(R.id.toolbar_fragment_life_iv);
        timerTv = mContentView.findViewById(R.id.toolbar_fragment_timer_tv);
    }



    private void setupUiViews() {
        setupLifeViews();
    }

    private void setupLifeViews() {
        HashMap<String, Object> lifeDatas = DataManager.getInstance().getLifeData();
        int lifeNumber = (int) lifeDatas.get(Constants.LIFE_POSITION);

        lifeTv.setText(String.valueOf(lifeNumber));
        if (lifeNumber != 5) {
            long lastUpdate = (long) lifeDatas.get(Constants.LAST_UPDATE);
            setLifeTimer(lastUpdate);
        } else {
            timerTv.setText(getString(R.string.full_life));
        }
    }

    private void setupListeners() {
        mViewModel.setLifeNumberLiveData();
        mViewModel.getLifeNumberLiveData().observe(requireActivity(), lifeNumber -> {
            setupLifeViews();
        });
    }

    private void setLifeTimer(long lastUpdate) {

    }



}
