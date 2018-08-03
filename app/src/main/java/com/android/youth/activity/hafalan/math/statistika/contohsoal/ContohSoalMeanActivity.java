package com.android.youth.activity.hafalan.math.statistika.contohsoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.activity.hafalan.math.statistika.contohsoal.pembahasan.PembahasanMeanActivity;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContohSoalMeanActivity extends BaseToolbarActivity {

    @BindView(R.id.btnPembahasan)
    Button btnPembahasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contoh_soal_mean);
        ButterKnife.bind(this);
        setToolbar(getString(R.string.math_statistic));

        btnPembahasan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPembahasan) {
            Intent intentMean = new Intent(ContohSoalMeanActivity.this, PembahasanMeanActivity.class);
            startActivity(intentMean);
            finish();
        }
    }
}
