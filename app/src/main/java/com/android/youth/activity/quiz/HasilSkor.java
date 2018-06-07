package com.android.youth.activity.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.youth.R;
import com.android.youth.activity.MenuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HasilSkor extends Activity {

    @BindView(R.id.talk1)
    TextView talk1;

    @BindView(R.id.talk2)
    TextView talk2;

    @BindView(R.id.tvSkorAkhir)
    TextView mtvHasilAkhir;

    @BindView(R.id.btnMenu)
    Button mbtnMenu;

    @BindView(R.id.imgTalk1)
    ImageView image1;

    @BindView(R.id.imgTalk2)
    ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_skor);
        ButterKnife.bind(this);

        setSkor();

        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HasilSkor.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void setSkor() {
        String activity = getIntent().getStringExtra("activity");
        String skorPilGan = getIntent().getStringExtra("skorAkhir");

        if (activity.equals("PilihanGanda")) {
            mtvHasilAkhir.setText("SKOR : " + skorPilGan);

            if (skorPilGan.equals("60")) {
                talk1.setVisibility(View.GONE);
                talk2.setVisibility(View.VISIBLE);
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
            } else if (skorPilGan.equals("50")) {
                talk1.setVisibility(View.GONE);
                talk2.setVisibility(View.VISIBLE);
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
            } else if (skorPilGan.equals("40")) {
                talk1.setVisibility(View.GONE);
                talk2.setVisibility(View.VISIBLE);
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
            } else if (skorPilGan.equals("30")) {
                talk1.setVisibility(View.GONE);
                talk2.setVisibility(View.VISIBLE);
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
            } else if (skorPilGan.equals("20")) {
                talk1.setVisibility(View.GONE);
                talk2.setVisibility(View.VISIBLE);
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
            } else if (skorPilGan.equals("10")) {
                talk1.setVisibility(View.GONE);
                talk2.setVisibility(View.VISIBLE);
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
            }
        }
    }

    public void onBackPressed() {
        Toast.makeText(this, "Tidak bisa kembali, silahkan tekan menu", Toast.LENGTH_SHORT).show();
    }
}