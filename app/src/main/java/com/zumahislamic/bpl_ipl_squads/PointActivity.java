package com.zumahislamic.bpl_ipl_squads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class PointActivity extends AppCompatActivity {
    WebView webView; String URL="https://www.google.com/search?q=Point+table+bpl+2023&sca_esv=568517199&rlz=1C1CHBD_enBD1055BD1055&sxsrf=AM9HkKlsnBjmWaQIvVpqBLVifPrrvOJ7Og%3A1695738660164&ei=JOsSZfSzCcGgseMP9pSxkA0&ved=0ahUKEwj01eHjvsiBAxVBUGwGHXZKDNIQ4dUDCBA&uact=5&oq=Point+table+bpl+2023&gs_lp=Egxnd3Mtd2l6LXNlcnAiFFBvaW50IHRhYmxlIGJwbCAyMDIzMgkQABgNGBMYgAQyCxAAGA0YExiABBgKMgsQABgNGBMYgAQYCjIJEAAYDRgTGIAEMgsQABgNGBMYgAQYCjIJEAAYDRgTGIAEMgkQABgNGBMYgAQyCxAAGA0YExiABBgKMgkQABgNGBMYgAQyCRAAGA0YExiABEirHFD-A1ilB3ABeAGQAQCYAcoBoAGPA6oBBTAuMS4xuAEDyAEA-AEBwgIKEAAYRxjWBBiwA8ICChAAGIoFGLADGEPCAhAQLhiKBRjIAxiwAxhD2AEB4gMEGAAgQYgGAZAGDLoGBAgBGAg&sclient=gws-wiz-serp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        webView=findViewById(R.id.webView);



        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(URL);

        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (webView != null) {
                            if (webView.canGoBack()) {
                                webView.goBack();
                            } else {
                                onBackPressed();
                            }
                        }
                    }
                }
                return true;

            }
        });










    }
}