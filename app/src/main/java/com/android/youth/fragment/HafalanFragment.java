package com.android.youth.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.youth.R;
import com.android.youth.activity.hafalan.EnglishActivity;
import com.android.youth.activity.hafalan.IndonesiaActivity;
import com.android.youth.activity.hafalan.MathActivity;
import com.android.youth.base.BaseFragment;
import com.android.youth.component.CustomListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HafalanFragment extends BaseFragment {

    @BindView(R.id.btnEnglish)
    CustomListFragment btnEnglish;

    @BindView(R.id.btnIndonesia)
    CustomListFragment btnIndonesia;

    @BindView(R.id.btnMath)
    CustomListFragment btnMath;

    public HafalanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hafalan, container, false);
        ButterKnife.bind(this, view);

        btnEnglish.setOnClickListener(this);
        btnIndonesia.setOnClickListener(this);
        btnMath.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnEnglish) {
            Intent intentEnglish = new Intent(getActivity(), EnglishActivity.class);
            startActivity(intentEnglish);

        } else if (v.getId() == R.id.btnIndonesia) {
            Intent intentIndonesia = new Intent(getActivity(), IndonesiaActivity.class);
            startActivity(intentIndonesia);

        } else if (v.getId() == R.id.btnMath) {
            Intent intentMath = new Intent(getActivity(), MathActivity.class);
            startActivity(intentMath);
        }
    }
}
