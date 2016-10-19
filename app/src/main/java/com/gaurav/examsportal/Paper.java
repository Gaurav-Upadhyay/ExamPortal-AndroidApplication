package com.gaurav.examsportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Paper extends AppCompatActivity {
    String s;
    String c;
    String d;


    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //your handling...
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);


        WebView webview = (WebView) findViewById(R.id.webView);
        webview.setWebViewClient(new MyWebViewClient());
        webview.getSettings().setBuiltInZoomControls(false);
        webview.getSettings().setSupportZoom(false);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setAllowFileAccess(true);
        webview.getSettings().setDomStorageEnabled(true);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);


        Intent intent = getIntent();
        c = intent.getExtras().getString("b1");
        d = intent.getExtras().getString("b2");
        s = c + d;

        if (s.equals("11")) {
            webview.loadUrl("file:///android_asset/11.html");
        }
        if (s.equals("12")) {
            webview.loadUrl("file:///android_asset/12.html");
        }
        if (s.equals("13")) {
            webview.loadUrl("file:///android_asset/13.html");
        }
        if (s.equals("14")) {
            webview.loadUrl("file:///android_asset/14.html");
        }
        if (s.equals("21")) {
            webview.loadUrl("file:///android_asset/21.html");
        }
        if (s.equals("22")) {
            webview.loadUrl("file:///android_asset/22.html");
        }
        if (s.equals("23")) {
            webview.loadUrl("file:///android_asset/23.html");
        }
        if (s.equals("24")) {
            webview.loadUrl("file:///android_asset/24.html");
        }
        if (s.equals("31")) {
            webview.loadUrl("file:///android_asset/31.html");
        }
        if (s.equals("32")) {
            webview.loadUrl("file:///android_asset/32.html");
        }
        if (s.equals("33")) {
            webview.loadUrl("file:///android_asset/33.html");
        }
        if (s.equals("34")) {
            webview.loadUrl("file:///android_asset/34.html");
        }
        if (s.equals("41")) {
            webview.loadUrl("file:///android_asset/41.html");
        }
        if (s.equals("42")) {
            webview.loadUrl("file:///android_asset/42.html");
        }
        if (s.equals("43")) {
            webview.loadUrl("file:///android_asset/43.html");
        }
        if (s.equals("44")) {
            webview.loadUrl("file:///android_asset/44.html");
        }
        if (s.equals("51")) {
            webview.loadUrl("file:///android_asset/51.html");
        }
        if (s.equals("52")) {
            webview.loadUrl("file:///android_asset/52.html");
        }
        if (s.equals("53")) {
            webview.loadUrl("file:///android_asset/53.html");
        }
        if (s.equals("54")) {
            webview.loadUrl("file:///android_asset/54.html");
        }
        if (s.equals("61")) {
            webview.loadUrl("file:///android_asset/61.html");
        }
        if (s.equals("62")) {
            webview.loadUrl("file:///android_asset/62.html");
        }
        if (s.equals("63")) {
            webview.loadUrl("file:///android_asset/63.html");
        }
        if (s.equals("64")) {
            webview.loadUrl("file:///android_asset/64.html");
        }
        if (s.equals("71")) {
            webview.loadUrl("file:///android_asset/71.html");
        }
        if (s.equals("72")) {
            webview.loadUrl("file:///android_asset/72.html");
        }
        if (s.equals("73")) {
            webview.loadUrl("file:///android_asset/73.html");
        }
        if (s.equals("74")) {
            webview.loadUrl("file:///android_asset/74.html");
        }
        if (s.equals("81")) {
            webview.loadUrl("file:///android_asset/81.html");
        }
        if (s.equals("82")) {
            webview.loadUrl("file:///android_asset/82.html");
        }
        if (s.equals("83")) {
            webview.loadUrl("file:///android_asset/83.html");
        }
        if (s.equals("84")) {
            webview.loadUrl("file:///android_asset/84.html");
        }

    }
}
