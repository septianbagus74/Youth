package com.android.youth.activity.hafalan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.youth.R;
import com.android.youth.activity.hafalan.math.HafalanMathStatistikaActivity;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MathActivity extends BaseToolbarActivity {

    @BindView(R.id.imgMatrix)
    ImageView imgMatrix;

//    @BindView(R.id.imgEksponen)
//    ImageView imgEksponen;
//
//    @BindView(R.id.imgBarisDanDeret)
//    ImageView imgBarisDanDeret;

    Animation animBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        ButterKnife.bind(this);
        setToolbar("Hafalan Matematika");

        animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        imgMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgMatrix.startAnimation(animBounce);
                Intent intentMatrix = new Intent(MathActivity.this, HafalanMathStatistikaActivity.class);
                startActivity(intentMatrix);
            }
        });

//        imgEksponen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgEksponen.startAnimation(animBounce);
//                Intent intentMatrix = new Intent(MathActivity.this, HafalanMathEksponenActivity.class);
//                startActivity(intentMatrix);
//            }
//        });
//
//        imgBarisDanDeret.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgBarisDanDeret.startAnimation(animBounce);
//                Intent intentBarisDeret = new Intent(MathActivity.this, HafalanMathBarisDeretActivity.class);
//                startActivity(intentBarisDeret);
//            }
//        });
    }

    @Override
    public void onClick(View view) {

    }
}
