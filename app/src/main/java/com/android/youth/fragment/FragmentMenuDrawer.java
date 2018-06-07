package com.android.youth.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.youth.R;
import com.android.youth.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentMenuDrawer extends Fragment implements View.OnClickListener {

    public MenuListener mListener;

    @BindView(R.id.tvMenuDashboard)
    TextView tvMenuDashboard;

    @BindView(R.id.tvMenuRecitation)
    TextView tvMenuRecitation;

    @BindView(R.id.tvMenuQuiz)
    TextView tvMenuQuiz;

    @BindView(R.id.tvMenuLogout)
    TextView tvMenuLogout;

    @BindView(R.id.tvMenuAbout)
    TextView tvMenuAbout;

//    @BindView(R.id.tvMenuPoin)
//    TextView tvMenuPoin;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (MenuListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_drawer, container, false);
        ButterKnife.bind(this, view);

        tvMenuDashboard.setOnClickListener(this);
        tvMenuRecitation.setOnClickListener(this);
        tvMenuQuiz.setOnClickListener(this);
        tvMenuAbout.setOnClickListener(this);
//        tvMenuPoin.setOnClickListener(this);
        tvMenuLogout.setOnClickListener(this);

        if (savedInstanceState == null) {
            tvMenuDashboard.setBackgroundResource(R.color.transparent);
        }

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        setActiveMenu(v);

        switch (v.getId()) {
            case R.id.tvMenuDashboard:
                mListener.onMenuSelected(Constant.POSITION_WELCOME_FRAGMENT);
                break;

            case R.id.tvMenuRecitation:
                mListener.onMenuSelected(Constant.POSITION_RECITATION);
                break;

            case R.id.tvMenuQuiz:
                mListener.onMenuSelected(Constant.POSITION_QUIZ);
                break;

            case R.id.tvMenuAbout:
                mListener.onMenuSelected(Constant.POSITION_ABOUT);
                break;

//            case R.id.tvMenuPoin:
//                mListener.onMenuSelected(Constant.POSITION_POIN);
//                break;

            case R.id.tvMenuLogout:
                mListener.onMenuSelected(Constant.POSITION_LOGOUT);
                break;

            default:
                break;
        }
    }

    private void setActiveMenu(View view) {
        if (!(view == tvMenuLogout)) {
            tvMenuDashboard.setBackgroundResource(R.color.transparent);
            tvMenuRecitation.setBackgroundResource(R.color.transparent);
            tvMenuQuiz.setBackgroundResource(R.color.transparent);
            tvMenuAbout.setBackgroundResource(R.color.transparent);
//            tvMenuPoin.setBackgroundResource(R.color.transparent);

            view.setBackgroundResource(R.color.button_menu_pressed);
        }
    }

    public interface MenuListener {
        void onMenuSelected(int position);
    }
}
