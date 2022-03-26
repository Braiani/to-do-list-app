package com.br.brtechsistemas.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        TextView textView = (TextView) findViewById(R.id.textView);

        CustomWebViewClient webViewClient = new CustomWebViewClient(this, progressBar, textView);
        myWebView.setWebViewClient(webViewClient);

        myWebView.loadUrl("http://to-do-lists.tk/");

        //Habilitando o JavaScript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}