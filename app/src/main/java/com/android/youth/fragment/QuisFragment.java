package com.android.youth.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.youth.R;
import com.android.youth.activity.quiz.QuisDuaActivity;
import com.android.youth.activity.quiz.QuisSatuActivity;
import com.android.youth.base.BaseFragment;
import com.android.youth.component.CustomListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuisFragment extends BaseFragment {

    @BindView(R.id.level1)
    CustomListFragment level1;

    @BindView(R.id.level2)
    CustomListFragment level2;

    @BindView(R.id.level3)
    CustomListFragment level3;

    @BindView(R.id.level4)
    CustomListFragment level4;

    @BindView(R.id.level5)
    CustomListFragment level5;

    public QuisFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quis, container, false);
        ButterKnife.bind(this, view);

        level1.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
        level4.setOnClickListener(this);
        level5.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.level1) {
            Intent intentQuisSatu = new Intent(getActivity(), QuisSatuActivity.class);
            intentQuisSatu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentQuisSatu);
            getActivity().finish();

        } else if (v.getId() == R.id.level2) {
            Intent intentQuisDua = new Intent(getActivity(), QuisDuaActivity.class);
            intentQuisDua.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intentQuisDua);
            getActivity().finish();
//
//        } else if (v.getId() == R.id.level3) {
//            Intent intentMath = new Intent(getActivity(), MathActivity.class);
//            startActivity(intentMath);
//
//        } else if (v.getId() == R.id.level4) {
//            Intent intentMath = new Intent(getActivity(), MathActivity.class);
//            startActivity(intentMath);
//
//        } else if (v.getId() == R.id.level5) {
//            Intent intentMath = new Intent(getActivity(), MathActivity.class);
//            startActivity(intentMath);
//        }
        }
    }
}