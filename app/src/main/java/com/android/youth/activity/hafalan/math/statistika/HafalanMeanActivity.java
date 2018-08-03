package com.android.youth.activity.hafalan.math.statistika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.activity.hafalan.math.statistika.contohsoal.ContohSoalMeanActivity;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HafalanMeanActivity extends BaseToolbarActivity {

    @BindView(R.id.btnContohSoal)
    Button btnContohSoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafalan_mean);
        ButterKnife.bind(this);
        setToolbar(getString(R.string.math_statistic));

        btnContohSoal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnContohSoal) {
            Intent intentMean = new Intent(HafalanMeanActivity.this, ContohSoalMeanActivity.class);
            startActivity(intentMean);
        }
    }
}
