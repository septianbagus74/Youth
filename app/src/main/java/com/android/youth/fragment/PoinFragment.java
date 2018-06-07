package com.android.youth.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.activity.poin.RiwayatPoinActivity;
import com.android.youth.activity.poin.TukarPoinActivity;
import com.android.youth.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PoinFragment extends BaseFragment {

    @BindView(R.id.btnRiwayatPoin)
    Button btnRiwayatPoin;

    @BindView(R.id.btnTukarPoin)
    Button btnTukarPoin;

    public PoinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poin, container, false);
        ButterKnife.bind(this, view);

        btnRiwayatPoin.setOnClickListener(this);
        btnTukarPoin.setOnClickListener(this);

        //Set Label Version
        PackageInfo pInfo = null;
        try {
            pInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRiwayatPoin) {
            Intent intent = new Intent(getActivity(), RiwayatPoinActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnTukarPoin) {
            Intent intent = new Intent(getActivity(), TukarPoinActivity.class);
            startActivity(intent);
        }
    }
}