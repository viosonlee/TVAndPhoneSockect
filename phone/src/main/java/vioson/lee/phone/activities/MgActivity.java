package vioson.lee.phone.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import vioson.lee.phone.AppDataHandler;
import vioson.lee.phone.R;
import vioson.lee.phone.UrlTool;
import vioson.lee.phone.network.ApiException;
import vioson.lee.phone.network.BaseObserver;
import vioson.lee.phone.network.BaseResponse;
import vioson.lee.phone.network.Requester;
import vioson.lee.phone.network.SocketService;
import vioson.lee.phone.pojo.Step1Data;
import vioson.lee.phone.pojo.Step2Response;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class MgActivity extends AppCompatActivity {
    private TextView message;
    private EditText input, ip;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mg);
        message = findViewById(R.id.message);
        input = findViewById(R.id.input);
        String lastVideoID = AppDataHandler.getLastVideoId(this);
        if (!TextUtils.isEmpty(lastVideoID)) {
            input.setText(lastVideoID);
        }
        ip = findViewById(R.id.ip);
        String ipLast = AppDataHandler.getIp(this);
        if (!TextUtils.isEmpty(ipLast)) {
            ip.setText(ipLast);
        }
        intent = new Intent(this, SocketService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (intent != null) {
            stopService(intent);
        }
    }

    public void connect(View view) {
        String ipTxt = ip.getText().toString().trim();
        if (TextUtils.isEmpty(ipTxt))
            Toast.makeText(this, "ip不能为空", Toast.LENGTH_SHORT).show();
        message.setText("正在连接电视...");
        SocketService.connect(ipTxt, new SocketService.ConnectCallback() {
            @Override
            public void onConnected() {
                message.setText("连接成功");
                AppDataHandler.saveIp(MgActivity.this, ipTxt);
            }

            @Override
            public void onDisConnected() {
                message.setText("连接已断开");
            }

            @Override
            public void onError(Throwable throwable) {
                message.setText(String.format("连接失败:%s", throwable.getMessage()));
            }
        });
    }

    public void send(View view) {
        String videoNumber = input.getText().toString().trim();
        if (TextUtils.isEmpty(videoNumber))
            Toast.makeText(this, "请填写视频编号", Toast.LENGTH_SHORT).show();
        AppDataHandler.saveLastVideoId(this, videoNumber);
        jiexi(videoNumber);
    }

    private void jiexi(String videoNumber) {
        message.setText("正在获取视频地址");
        Requester.stepOne(videoNumber, new BaseObserver<Step1Data>() {
            @Override
            protected void onHandleSuccess(Step1Data data) {
                if (data != null && data.getStream() != null) {
                    List<Step1Data.StreamBean> stream = data.getStream();
                    for (int i = stream.size() - 1; i >= 0; i--) {
                        Step1Data.StreamBean streamBean = stream.get(i);
                        if (!TextUtils.isEmpty(streamBean.getUrl())) {
                            jiexi2(streamBean.getUrl());
                            break;
                        }
                    }
                }
            }

            @Override
            protected void onHandleError(ApiException e) {
                super.onHandleError(e);
                message.setText(e.getMessage());
            }
        });
    }

    private void jiexi2(String url) {
        message.setText("正在获取视频播放地址");
        Requester.stepTwo(url, new Observer<Step2Response>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Step2Response data) {
                if (data != null) {
                    jiexi3(data.getInfo());
                }
            }

            @Override
            public void onError(Throwable e) {
                message.setText(e.getMessage());
            }

            @Override
            public void onComplete() {

            }

        });
    }

    private void jiexi3(String info) {
        if (TextUtils.isEmpty(info)) {
            message.setText("播放地址为空");
            return;
        }
        try {
            info = info.replace("http://", "");
            info = info.replace("https://", "");
            String file = info.substring(info.indexOf("/"), info.indexOf("?"));
            String fid = file;
            for (int i = 0; i < 5; i++) {
                fid = fid.substring(fid.indexOf("/") + 1);
            }
            fid = fid.substring(0, fid.indexOf("_"));
            String fmt = "4";
            String pno = "3001";
            String videoUrl = UrlTool.getVideoUrl(fmt, pno, fid, file) + "\0";
            message.setText(String.format("播放地址为：%s", videoUrl));
            SocketService.send(videoUrl, new SocketService.SendCallback() {
                @Override
                public void onSendOk() {
                    message.setText("已发送至电视,即将开始播放");
                }

                @Override
                public void onError(Throwable throwable) {
                    message.setText("出现错误：" + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
