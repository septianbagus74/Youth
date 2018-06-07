package com.android.youth.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.youth.R;
import com.android.youth.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeFragment extends BaseFragment {

    @BindView(R.id.imgTalk1)
    ImageView imgTalk1;

    @BindView(R.id.imgTalk2)
    ImageView imgTalk2;

    @BindView(R.id.talk1)
    TextView talk1;

    @BindView(R.id.talk2)
    TextView talk2;

    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, view);

        talk1.setOnClickListener(this);
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
        if (view.getId() == R.id.talk1) {
            talk1.setVisibility(View.GONE);
            imgTalk1.setVisibility(View.GONE);
            talk2.setVisibility(View.VISIBLE);
            imgTalk2.setVisibility(View.VISIBLE);
        }
    }
}