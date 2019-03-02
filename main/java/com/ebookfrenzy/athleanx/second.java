package com.ebookfrenzy.athleanx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class second extends Fragment {
    public second(){    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.second, container, false);
        return rootView;
    }

    public static second newInstance(String text) {

        second f = new second();
        Bundle b = new Bundle();
        b.putString("mhgf", text);

        f.setArguments(b);

        return f;
    }
}