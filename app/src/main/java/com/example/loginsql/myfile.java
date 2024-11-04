package com.example.loginsql;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.loginsql.databinding.ActivityMyfileBinding;


public class myfile extends AppCompatActivity {

    ActivityMyfileBinding binding;

    private String url;
    WebView webView;

    ValueCallback<Uri[]>upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.FooterHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myfile.this,MainActivity.class);
                startActivity(intent);

            }
        });
        binding.FooterDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myfile.this,dashboardactivity.class);
                startActivity(intent);

            }
        });
        binding.FooterSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myfile.this,schoolactivity.class);
                startActivity(intent);

            }
        });


        url = "https://onedrive.live.com/?id=3474BA89FEF3951%212671&cid=03474BA89FEF3951";
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new Myweb());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
                Intent intent;
                intent=fileChooserParams.createIntent();
                upload=filePathCallback;
                startActivityForResult(intent,101);
                return true;
            }
        });

    }

    private class Myweb extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101)
        {
            if (upload==null)
                return;

            upload.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode,data));
            upload=null;
        }


    }
}