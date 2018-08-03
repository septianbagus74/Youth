package com.android.youth.activity.hafalan.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.youth.R;
import com.android.youth.activity.hafalan.english.expression.NegativeExpressionActivity;
import com.android.youth.activity.hafalan.english.expression.PositiveExpressionActivity;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.component.CustomListHafalan;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HafalanEnglishExpressionActivity extends BaseToolbarActivity {

    @BindView(R.id.btnPositive)
    CustomListHafalan btnPositive;

    @BindView(R.id.btnNegative)
    CustomListHafalan btnNegative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafalan_english_expression);
        ButterKnife.bind(this);
        setToolbar(getString(R.string.english));

         btnPositive.setOnClickListener(this);
         btnNegative.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPositive){
            Intent intent = new Intent(HafalanEnglishExpressionActivity.this, PositiveExpressionActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.btnNegative){
            Intent intent = new Intent(HafalanEnglishExpressionActivity.this, NegativeExpressionActivity.class);
            startActivity(intent);
        }

    }
}
