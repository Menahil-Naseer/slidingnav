package com.example.slidingnav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MusicFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Remove the return statement below
        // return super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout and return the View
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        return view;
    }
}
