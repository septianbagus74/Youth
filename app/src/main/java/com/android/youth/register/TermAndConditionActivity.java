package com.android.youth.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TermAndConditionActivity extends BaseToolbarActivity {
    @BindView(R.id.tvAgree)
    Button btnAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_and_condition);
        ButterKnife.bind(this);
        setToolbar(getString(R.string.term_and_condition));

        btnAgree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intentAgree = new Intent(TermAndConditionActivity.this, SuccessRegisterActivity.class);
        startActivity(intentAgree);
        finish();

    }
}
