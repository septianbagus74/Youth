package com.android.youth.activity.hafalan.english.expression;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.activity.MenuActivity;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PositiveExpressionActivity extends BaseToolbarActivity {

    @BindView(R.id.btnContohSoal)
    Button btnContohSoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positive_expression);
        ButterKnife.bind(this);

        btnContohSoal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnContohSoal) {
            Intent intentMean = new Intent(PositiveExpressionActivity.this, MenuActivity.class);
            startActivity(intentMean);
        }
    }
}
