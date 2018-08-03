package com.android.youth.activity.hafalan.english;

import android.os.Bundle;
import android.view.View;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.ButterKnife;

public class HafalanEnglishGrammarActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hafalan_english_grammar);
        ButterKnife.bind(this);
        setToolbar(getString(R.string.english));

    }

    @Override
    public void onClick(View view) {

    }
}
