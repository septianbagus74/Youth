package com.android.youth.activity.hafalan.math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.youth.R;
import com.android.youth.activity.hafalan.math.statistika.HafalanMeanActivity;
import com.android.youth.activity.hafalan.math.statistika.HafalanMedianActivity;
import com.android.youth.activity.hafalan.math.statistika.HafalanModusActivity;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.component.CustomListHafalan;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HafalanMathStatistikaActivity extends BaseToolbarActivity {

    @BindView(R.id.btnMean)
    CustomListHafalan btnMean;

    @BindView(R.id.btnMedian)
    CustomListHafalan btnMedian;

    @BindView(R.id.btnModus)
    CustomListHafalan btnModus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafalan_statistika_math);
        ButterKnife.bind(this);
        setToolbar(getString(R.string.math_statistic));

        btnMean.setOnClickListener(this);
        btnMedian.setOnClickListener(this);
        btnModus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnMean) {
            Intent intentMean = new Intent(HafalanMathStatistikaActivity.this, HafalanMeanActivity.class);
            startActivity(intentMean);

        } else if (v.getId() == R.id.btnMedian) {
            Intent intentMedian = new Intent(HafalanMathStatistikaActivity.this, HafalanMedianActivity.class);
            startActivity(intentMedian);

        } else if (v.getId() == R.id.btnModus) {
            Intent intentModus = new Intent(HafalanMathStatistikaActivity.this, HafalanModusActivity.class);
            startActivity(intentModus);
        }
    }
}
