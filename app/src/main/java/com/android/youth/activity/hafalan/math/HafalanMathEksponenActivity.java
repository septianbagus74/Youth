package com.android.youth.activity.hafalan.math;

import android.os.Bundle;
import android.view.View;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.component.CustomListHafalan;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HafalanMathEksponenActivity extends BaseToolbarActivity {

    @BindView(R.id.btnSifatPositif)
    CustomListHafalan btnSifatPositif;

    @BindView(R.id.btnSifatNol)
    CustomListHafalan btnSifatNol;

    @BindView(R.id.btnSifatNegatif)
    CustomListHafalan btnSifatNegatif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafalan_math_eksponen);
        ButterKnife.bind(this);
        setToolbar("Matriks");

        btnSifatPositif.setOnClickListener(this);
        btnSifatNol.setOnClickListener(this);
        btnSifatNegatif.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSifatPositif) {
//            Intent intentPositif = new Intent(HafalanMathEksponenActivity.this, EnglishActivity.class);
//            startActivity(intentPositif);

        } else if (v.getId() == R.id.btnSifatNol) {
//            Intent intentNol = new Intent(HafalanMathEksponenActivity.this, IndonesiaActivity.class);
//            startActivity(intentNol);

        } else if (v.getId() == R.id.btnSifatNegatif) {
//            Intent intentNegatif = new Intent(HafalanMathEksponenActivity.this, MathActivity.class);
//            startActivity(intentNegatif);
        }
    }
}
