package com.android.youth.activity.quiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.youth.R;
import com.android.youth.base.BaseToolbarActivity;
import com.android.youth.soal.SoalLevel2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuisDuaActivity extends BaseToolbarActivity {

    @BindView(R.id.tvSkor)
    TextView mtvSkor;

    @BindView(R.id.tvSoal)
    TextView mtvSoal;

    @BindView(R.id.rgPilihanJawaban)
    RadioGroup mrgPilihanJawaban;

    @BindView(R.id.rbPilihanJawaban1)
    RadioButton mrbPilihanJawaban1;

    @BindView(R.id.rbPilihanJawaban2)
    RadioButton mrbPilihanJawaban2;

    @BindView(R.id.rbPilihanJawaban3)
    RadioButton mrbPilihanJawaban3;

    @BindView(R.id.btnSubmit)
    Button mbtnSubmit;

    int skor = 0;
    int arr;
    int x;
    String jawaban;

    SoalLevel2 soalPG = new SoalLevel2();

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quis_dua);
        ButterKnife.bind(this);
        setToolbarDisabledBackButton(getString(R.string.quiz));

        mediaPlayer = MediaPlayer.create(QuisDuaActivity.this,R.raw.quistwo);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        mtvSkor.setText("" + skor);
        setKonten();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setKonten() {
        mrgPilihanJawaban.clearCheck();
        arr = soalPG.pertanyaan.length;
        if (x >= arr) {
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(QuisDuaActivity.this, HasilSkor.class);
            i.putExtra("skorAkhir", jumlahSkor);
            i.putExtra("activity", "PilihanGanda");
            startActivity(i);
            mediaPlayer.stop();
            finish();

        } else {

            mtvSoal.setText(soalPG.getPertanyaan(x));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(x));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(x));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(x));
            jawaban = soalPG.getJawabanBenar(x);

        }
        x++;
    }

    public void cekJawaban() {
        if (mrbPilihanJawaban1.isChecked()) {
            if (mrbPilihanJawaban1.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            } else {
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        } else if (mrbPilihanJawaban2.isChecked()) {
            if (mrbPilihanJawaban2.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            } else {
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        } else if (mrbPilihanJawaban3.isChecked()) {
            if (mrbPilihanJawaban3.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            } else {
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        } else {
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {

    }
}
