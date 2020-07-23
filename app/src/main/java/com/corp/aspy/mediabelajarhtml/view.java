package com.corp.aspy.mediabelajarhtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class view extends AppCompatActivity {
    WebView webView;
    String coba;
    int command;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        webView = (WebView) findViewById(R.id.webview);
        coba = getIntent().getExtras().getString("Value");
        command = getIntent().getExtras().getInt("command");
        webView.loadData(coba,"text/html; charset=utf-8", "utf-8");
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(view.this, Exercise.class);
        intent.putExtra("command", command);
        startActivity(intent);
        finish();
    }
}

