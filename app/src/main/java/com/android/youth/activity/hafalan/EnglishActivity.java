package com.android.youth.activity.hafalan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.youth.R;
import com.android.youth.activity.hafalan.english.HafalanEnglishExpressionActivity;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EnglishActivity extends BaseToolbarActivity {

    @BindView(R.id.imgExpression)
    ImageView imgExpression;

    @BindView(R.id.imgGrammar)
    ImageView imgGrammar;

    @BindView(R.id.imgText)
    ImageView imgText;

    Animation animBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        ButterKnife.bind(this);
        setToolbar("Hafalan Bahasa Inggris");

        animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);

        imgExpression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgExpression.startAnimation(animBounce);
                Intent intentExpression = new Intent(EnglishActivity.this, HafalanEnglishExpressionActivity.class);
                startActivity(intentExpression);
            }
        });

        imgGrammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGrammar.startAnimation(animBounce);
                Intent intentGrammar = new Intent(EnglishActivity.this, HafalanEnglishExpressionActivity.class);
                startActivity(intentGrammar);
            }
        });

        imgText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgText.startAnimation(animBounce);
                Intent intentText = new Intent(EnglishActivity.this, HafalanEnglishExpressionActivity.class);
                startActivity(intentText);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
