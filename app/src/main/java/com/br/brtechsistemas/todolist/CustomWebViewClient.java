package com.br.brtechsistemas.todolist;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CustomWebViewClient extends WebViewClient {

    private Activity activity = null;
    private ProgressBar progressBar = null;
    private TextView textView = null;

    public CustomWebViewClient(Activity activity, ProgressBar progressBar, TextView textView) {
        this.activity = activity;
        this.progressBar = progressBar;
        this.textView = textView;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        if(url.contains("to-do-lists.tk")) return false;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(intent);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        showLoading(view);
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        hideLoading(view);
        super.onPageFinished(view, url);
    }

    private void showLoading(WebView webView) {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        webView.setVisibility(View.INVISIBLE);
    }

    private void hideLoading(WebView webView) {
        progressBar.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        webView.setVisibility(View.VISIBLE);
    }

}
