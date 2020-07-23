package com.corp.aspy.mediabelajarhtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultQuiz extends AppCompatActivity {
    TextView bujur, salah;
    private long backPressed;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quiz);
        bujur = (TextView) findViewById(R.id.bujurjawaban_txt);
        salah = (TextView) findViewById(R.id.salahjawaban_txt);
        String jawabanbenar, jawabansalah;
        jawabanbenar = getIntent().getExtras().getString("bujur");
        jawabansalah = getIntent().getExtras().getString("salah");
        bujur.setText(jawabanbenar);
        salah.setText(jawabansalah);
    }
    public void onBackPressed(){
        startActivity(new Intent(ResultQuiz.this, MenuListView.class));
        finish();
    }
}
