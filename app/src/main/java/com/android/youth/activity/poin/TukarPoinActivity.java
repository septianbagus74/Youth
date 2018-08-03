package com.android.youth.activity.poin;

import android.os.Bundle;
import android.view.View;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.ButterKnife;

public class TukarPoinActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tukar_poin);
        ButterKnife.bind(this);

        setToolbar(getString(R.string.poin));
    }

    @Override
    public void onClick(View view) {

    }
}
