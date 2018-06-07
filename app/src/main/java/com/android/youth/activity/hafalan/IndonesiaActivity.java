package com.android.youth.activity.hafalan;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndonesiaActivity extends BaseToolbarActivity {

    @BindView(R.id.imgCerpen)
    ImageView imgCerpen;

    @BindView(R.id.imgIdePokok)
    ImageView imgIdePokok;

    @BindView(R.id.imgKesimpulan)
    ImageView imgKesimpulan;

    Animation animBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indonesia);
        ButterKnife.bind(this);
        setToolbar("Hafalan Bahasa Indonesia");

        animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        imgCerpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCerpen.startAnimation(animBounce);
            }
        });

        imgIdePokok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgIdePokok.startAnimation(animBounce);
            }
        });

        imgKesimpulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgKesimpulan.startAnimation(animBounce);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
