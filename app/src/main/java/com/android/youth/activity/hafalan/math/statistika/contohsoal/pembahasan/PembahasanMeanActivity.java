package com.android.youth.activity.hafalan.math.statistika.contohsoal.pembahasan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.youth.R;
import com.android.youth.activity.MenuActivity;
import com.android.youth.base.BaseToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PembahasanMeanActivity extends BaseToolbarActivity {

    @BindView(R.id.btnSelesai)
    Button selesai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembahasan_mean);
        ButterKnife.bind(this);
        setToolbar(getString(R.string.math));

        selesai.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSelesai){
            Intent intentSelesai = new Intent(PembahasanMeanActivity.this, MenuActivity.class);
            startActivity(intentSelesai);
            finish();
        }

    }
}
