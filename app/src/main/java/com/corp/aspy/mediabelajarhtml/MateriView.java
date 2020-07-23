package com.corp.aspy.mediabelajarhtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;

public class MateriView extends AppCompatActivity {
    private Button btnCoba, btnExercise, btnQuiz;
    private TextView txtTitle, txtMateri;
    int command;
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_view);
        btnCoba = (Button) findViewById(R.id.CobaHtml_btn);
        btnExercise = (Button) findViewById(R.id.ExerciseHtml_btn);
        btnQuiz = (Button) findViewById(R.id.Quiz_btn);
        txtTitle = (TextView) findViewById(R.id.title_mater);
        txtMateri = (TextView) findViewById(R.id.materi_paragraph);
        command = getIntent().getExtras().getInt("command");
        btnCoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MateriView.this, Exercise.class);
                intent.putExtra("command", command);
                startActivity(intent);
                finish();
            }
        });
        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MateriView.this, Quiz.class);
                startActivity(intent);
                finish();
            }
        });
        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MateriView.this, Exercise.class);
                intent.putExtra("command", 0);
                startActivity(intent);
                finish();
            }
        });
        if (command == 1) {
            txtTitle.setText("Introduction HTML");
            btnQuiz.setVisibility(View.INVISIBLE);
            try {
                InputStream is = getAssets().open("file_1.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            txtMateri.setText(text);
        }
        if (command == 2) {
            txtTitle.setText("HTML Style");
            btnQuiz.setVisibility(View.INVISIBLE);
            try {
                InputStream is = getAssets().open("file_2.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            txtMateri.setText(text);
        }
        if (command == 3) {
            txtTitle.setText("HTML Formatting");
            btnQuiz.setVisibility(View.INVISIBLE);
            try {
                InputStream is = getAssets().open("file_3.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            txtMateri.setText(text);
        }
        if (command == 4) {
            txtTitle.setText("HTML Colors");
            btnQuiz.setVisibility(View.INVISIBLE);
            try {
                InputStream is = getAssets().open("file_4.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            txtMateri.setText(text);
        }
        if (command == 5) {
            txtTitle.setText("HTML Images Syntax");
            btnQuiz.setVisibility(View.INVISIBLE);
            try {
                InputStream is = getAssets().open("file_5.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            txtMateri.setText(text);
        }
        if (command == 6) {
            txtTitle.setText("HTML Comment");
            btnQuiz.setVisibility(View.INVISIBLE);
            try {
                InputStream is = getAssets().open("file_6.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            txtMateri.setText(text);
        }
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(MateriView.this, MenuListView.class));
        finish();
    }
}

