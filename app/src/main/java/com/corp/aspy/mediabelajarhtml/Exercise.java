package com.corp.aspy.mediabelajarhtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Exercise extends AppCompatActivity {

    private EditText inputtext;
    private Button laksanakan;
    int command;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        inputtext = (EditText) findViewById(R.id.Edit_textEditor);
        laksanakan = (Button) findViewById(R.id.btn_laksanakan);
        String text = "";

        command = getIntent().getExtras().getInt("command");

        if (command == 1) {
            try {

                InputStream is = getAssets().open("file_1Cont.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputtext.setText(text);
        }
        if (command == 2){
            try {

                InputStream is = getAssets().open("file_2Cont.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputtext.setText(text);
        }
        if (command == 3){
            try {

                InputStream is = getAssets().open("file_3Cont.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputtext.setText(text);
        }
        if (command == 4){
            try {

                InputStream is = getAssets().open("file_4Cont.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputtext.setText(text);
        }
        if (command == 5){
            try {

                InputStream is = getAssets().open("file_5Cont.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputtext.setText(text);
        }
        if (command == 6){
            try {

                InputStream is = getAssets().open("file_6Cont.txt");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                text = new String(buffer);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            inputtext.setText(text);
        }
        laksanakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercise.this, view.class);
                String Viewer = inputtext.getText().toString();
                intent.putExtra("Value", Viewer);
                intent.putExtra("command", command);
                startActivity(intent);
                finish();


            }
        });
    }
    @Override
    public void onBackPressed() {
        if (command != 0) {
            Intent intent = new Intent(Exercise.this, MateriView.class);
            intent.putExtra("command", command);
            startActivity(intent);
            finish();
        }else{
            startActivity(new Intent(Exercise.this, MenuListView.class));
            finish();


        }
    }
}
