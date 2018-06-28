package com.android.youth.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuccessRegisterActivity extends BaseToolbarActivity {

    @BindView(R.id.tvDone)
    Button btnDone;

    @BindView(R.id.nestedLinear)
    LinearLayout nestedLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);
        ButterKnife.bind(this);
        setToolbarDisabledBackButton(getString(R.string.title_success));

        btnDone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intentDone = new Intent(SuccessRegisterActivity.this, LoginActivity.class);
        startActivity(intentDone);
        Snackbar.make(nestedLinear, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
        finish();
    }
}
