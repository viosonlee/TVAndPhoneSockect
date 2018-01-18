package vioson.lee.tvandphonesockect;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import lee.vioson.network.core.DebugLog;

/**
 * Created by viosonlee
 * on 2018/1/9.
 * for 浏览网页
 */

public class H5Activity extends AppCompatActivity {
    private WebView mWebView;
    private static final String URL = "web_url";
    private String url;
    private ImageView mouse;
    private Point mousePoint = new Point(100, 100);
    private static final int MOVE_VALUE = 20;
    private static Handler handler;

    public static void launch(Context context, String url) {
        Intent intent = new Intent(context, H5Activity.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_h5);
        createMessageHandleThread();
        mouse = findViewById(R.id.mouse);
        mWebView = findViewById(R.id.web_view);
        initSettings(mWebView);
        url = getIntent().getStringExtra(URL);
        DebugLog.i("url", url);
        if (!TextUtils.isEmpty(url)) {
            mWebView.loadUrl(url);
        }
    }

    private void createMessageHandleThread() {
        Thread t = new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {

                    }
                };
                Looper.loop();
            }
        };
        t.start();
    }


    private void initSettings(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setUseWideViewPort(true);
//        webView.getSettings().setBlockNetworkImage(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        String userAgentString = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";
        webView.getSettings().setUserAgentString(userAgentString);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });
    }

    private void refreshMouseLocation() {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mouse.getLayoutParams();
        lp.setMargins(mousePoint.x, mousePoint.y, 0, 0);
        mouse.setLayoutParams(lp);
        mouse.postInvalidate();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_CENTER:
                    //点击确认
                    touch();
                    return true;
                case KeyEvent.KEYCODE_ENTER:
                    return true;
                case KeyEvent.KEYCODE_DPAD_UP:
                    mousePoint.y -= MOVE_VALUE;
                    refreshMouseLocation();
                    return true;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    mousePoint.y += MOVE_VALUE;
                    refreshMouseLocation();
                    return true;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    mousePoint.x -= MOVE_VALUE;
                    refreshMouseLocation();
                    return true;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    mousePoint.x += MOVE_VALUE;
                    refreshMouseLocation();
                    return true;
                case KeyEvent.KEYCODE_MENU:
                    return true;
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack())
                        mWebView.goBack();
                    else finish();
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void touch() {
        handler.post(() -> {
            Instrumentation instrumentation = new Instrumentation();
            instrumentation.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, mousePoint.x, mousePoint.y, 0));
            instrumentation.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, mousePoint.x, mousePoint.y, 0));
        });
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
