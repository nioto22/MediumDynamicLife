package com.aprouxdev.mediumdynamiclifes.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aprouxdev.mediumdynamiclifes.R;

import androidx.fragment.app.Fragment;

public class ToolbarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.toolbar_fragment, container, false);
    }

}
