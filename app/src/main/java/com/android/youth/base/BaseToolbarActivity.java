package com.android.youth.base;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.youth.R;
import com.android.youth.activity.MenuActivity;

import butterknife.BindView;

/**
 * Created by septian.bagus on 14/05/2018.
 */

public abstract class BaseToolbarActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.toolbar_title)
    protected TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (!(this instanceof MenuActivity)) {
            if (item.getItemId() == android.R.id.home) {
                finish();
            }
        }

        return true;
    }

    protected void setToolbar(String title) {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbarTitle.setText(title.toUpperCase());
        mToolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
    }

//    protected void setToolbarTitleTransparent(String title) {
//        mToolbarTitle.setText(title.toUpperCase());
//        mToolbar.setBackgroundDrawable(new ColorDrawable(R.color.color_black));
//    }

    protected void setToolbarDisabledBackButton(String title) {
        setToolbar(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    protected void setToolbarTitle(String title) {
        mToolbarTitle.setText(title.toUpperCase());
//        mToolbar.setBackgroundDrawable(new ColorDrawable(R.color.color_black));
    }

}
