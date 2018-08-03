package com.android.youth.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

import com.android.youth.MainActivity;
import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.fragment.AboutUsFragment;
import com.android.youth.fragment.FragmentMenuDrawer;
import com.android.youth.fragment.HafalanFragment;
import com.android.youth.fragment.QuisFragment;
import com.android.youth.fragment.WelcomeFragment;
import com.android.youth.utils.Constant;
import com.android.youth.utils.DialogUtil;

import butterknife.ButterKnife;

public class MenuActivity extends BaseToolbarActivity implements FragmentMenuDrawer.MenuListener {

    FragmentManager fragmentManager;
    Fragment displayFragment;
    Fragment currentFragment;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        setToolbar("");
        setDrawerLayout();

        fragmentManager = getSupportFragmentManager();
        displayView(Constant.POSITION_WELCOME_FRAGMENT);
        mToolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
//        initData();
    }

    public void setDrawerLayout() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void displayView(int position) {
        switch (position) {
            case Constant.POSITION_WELCOME_FRAGMENT:
                setToolbarTitle("");
                displayFragment = new WelcomeFragment();
                break;

            case Constant.POSITION_RECITATION:
                setToolbarTitle(getString(R.string.recitation));
                displayFragment = new HafalanFragment();
                break;

            case Constant.POSITION_QUIZ:
                setToolbarTitle(getString(R.string.quiz));
                displayFragment = new QuisFragment();
                break;

//            case Constant.POSITION_POIN:
//                setToolbarTitle(getString(R.string.poin));
//                displayFragment = new PoinFragment();
//                break;

            case Constant.POSITION_ABOUT:
                setToolbarTitle(getString(R.string.about_us));
                displayFragment = new AboutUsFragment();
                break;

            case Constant.POSITION_LOGOUT:
                doLogout();
                break;

            default:
                break;
        }

        if (currentFragment != null
                && currentFragment.getClass().getSimpleName()
                .equals(displayFragment.getClass().getSimpleName())) {
            drawer.closeDrawers();
            return;
        } else if (displayFragment != null) {
            currentFragment = displayFragment;
            fragmentManager.beginTransaction().replace(R.id.fragmentFrame, displayFragment).commit();
            drawer.closeDrawers();
        }
    }

    private void doLogout() {
        DialogUtil.showConfirmationDialog(this, getString(R.string.dialog_logout), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public void onMenuSelected(int position) {
        displayView(position);
    }

    @Override
    public void onClick(View v) {

    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}