package vioson.lee.tvandphonesockect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class PlayActivity extends AppCompatActivity {
    private static final String URL = "url";
    private StandardGSYVideoPlayer player;
    private String url;

    public static void launch(Context context, String url) {
        Intent intent = new Intent(context, PlayActivity.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        player = findViewById(R.id.player);
        url = getIntent().getStringExtra(URL);
        if (!TextUtils.isEmpty(url)) {
            play();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
        GSYVideoManager.instance().releaseMediaPlayer();
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

    private void play() {
        Log.i("url", url);
        player.setUp(url, false, "");
        player.startPlayLogic();
        GSYVideoManager.instance().getMediaPlayer().setOnSeekCompleteListener(iMediaPlayer -> {
//            runOnUiThread(() -> Toast.makeText(PlayActivity.this, "播放完毕", Toast.LENGTH_SHORT).show());
//            finish();
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_CENTER:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_CENTER");
                    toggle();
                    break;
                case KeyEvent.KEYCODE_ENTER:
                    Log.i(getClass().getSimpleName(), "KEYCODE_ENTER");
                    toggle();
                    break;
                case KeyEvent.KEYCODE_DPAD_UP:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_UP");
                    upSpeed();
                    return true;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_DOWN");
                    downSpeed();
                    return true;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_LEFT");
                    seekToBack();
                    return true;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    Log.i(getClass().getSimpleName(), "KEYCODE_DPAD_RIGHT");
                    seekToAward();
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void upSpeed() {
        float speed = player.getSpeed();
        if (speed <= 1.95)
            player.setSpeedPlaying(speed + 0.05f, true);
        Toast.makeText(this, "不能在快了", Toast.LENGTH_SHORT).show();
    }

    private void downSpeed() {
        float speed = player.getSpeed();
        if (speed >= 0.55f)
            player.setSpeedPlaying(speed - 0.05f, true);
        else Toast.makeText(this, "不能再慢了", Toast.LENGTH_SHORT).show();
    }

    long seekTime = 0;
    long currentPosition = 0;

    private void seekToAward() {
        if (System.currentTimeMillis() - seekTime > 3000) {
            currentPosition = player.getCurrentPositionWhenPlaying();
        }
        seekTime = System.currentTimeMillis();
        Log.e("currentPosition", "" + currentPosition);
        currentPosition += 90 * 1000;
        GSYVideoManager.instance().getMediaPlayer().seekTo(currentPosition);
    }
    
    private void seekToBack() {
        if (System.currentTimeMillis() - seekTime > 3000) {
            currentPosition = player.getCurrentPositionWhenPlaying();
        }
        seekTime = System.currentTimeMillis();
        if (currentPosition > 90 * 1000) {
            GSYVideoManager.instance().getMediaPlayer().seekTo(currentPosition - 90 * 1000);
        } else {
            GSYVideoManager.instance().getMediaPlayer().seekTo(0);
        }
    }

    private void toggle() {
        if (GSYVideoManager.instance().getMediaPlayer().isPlaying())
            player.onVideoPause();
        else player.onVideoResume();
    }
}
