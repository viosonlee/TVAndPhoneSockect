package vioson.lee.tvandphonesockect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import lee.vioson.network.core.DebugLog;

/**
 * Created by viosonlee
 * on 2018/1/9.
 * for
 */

public class TbsActivity extends AppCompatActivity {
    private WebView mWebView;
    private static final String URL = "web_url";
    private String url;

    public static void launch(Context context, String url) {
        Intent intent = new Intent(context, TbsActivity.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_webview);
        mWebView = findViewById(R.id.web_view);
        initSettings(mWebView);
        url = getIntent().getStringExtra(URL);
        DebugLog.i("url",url);
//        url = "http://api.baiyug.cn/vip/index.php?url=https://v.qq.com/x/cover/sqeqd66fb9dxwmp.html";
        if (!TextUtils.isEmpty(url)) {
            mWebView.loadUrl(url);
//            mWebView.setInitialScale(10);
        }
    }


    private void initSettings(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBlockNetworkImage(true);
        webView.getSettings().setLoadWithOverviewMode(true);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        navigationBarStatusBar(this, hasFocus);
    }

    /**
     * 导航栏，状态栏隐藏
     *
     * @param activity
     */
    public static void navigationBarStatusBar(Activity activity, boolean hasFocus) {
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
