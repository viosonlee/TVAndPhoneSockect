package vioson.lee.phone.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import vioson.lee.phone.AppDataHandler;
import vioson.lee.phone.R;
import vioson.lee.phone.pojo.UrlTool;

public class MainActivity extends AppCompatActivity {

    private EditText editText_ip, editText_data;
    private OutputStream outputStream = null;
    private Socket socket = null;
    private String ip;
    private String data;
    private boolean socketStatus = false;
    private View loading;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_ip = findViewById(R.id.ip);
        String ip1 = AppDataHandler.getIp(this);
        if (!TextUtils.isEmpty(ip1))
            editText_ip.setText(ip1);
        editText_data = findViewById(R.id.input);
        loading = findViewById(R.id.loading);
        OnRadioCheckListener checkListener = new OnRadioCheckListener();
        ((RadioButton) findViewById(R.id.rb0)).setOnCheckedChangeListener(checkListener);
        ((RadioButton) findViewById(R.id.rb1)).setOnCheckedChangeListener(checkListener);
        ((RadioButton) findViewById(R.id.rb2)).setOnCheckedChangeListener(checkListener);
        ((RadioButton) findViewById(R.id.rb3)).setOnCheckedChangeListener(checkListener);
        ((RadioButton) findViewById(R.id.rb4)).setOnCheckedChangeListener(checkListener);
        ((RadioButton) findViewById(R.id.rb5)).setOnCheckedChangeListener(checkListener);
        ((RadioButton) findViewById(R.id.rb6)).setOnCheckedChangeListener(checkListener);
        ((RadioButton) findViewById(R.id.rb7)).setOnCheckedChangeListener(checkListener);

    }

    class OnRadioCheckListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                index = Integer.parseInt(buttonView.getTag().toString());
            }
        }
    }

    public void connect(View view) {
        ip = editText_ip.getText().toString();
        if (TextUtils.isEmpty(ip)) {
            Toast.makeText(MainActivity.this, "please input Server IP", Toast.LENGTH_SHORT).show();
        }
        AppDataHandler.saveIp(this, ip);
        loading.setVisibility(View.VISIBLE);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                if (!socketStatus) {
                    try {
                        socket = new Socket(ip, 8000);
                        socketStatus = true;
                        runOnUiThread(() -> {
                            loading.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "连接成功!", Toast.LENGTH_SHORT).show();
                        });
                        outputStream = socket.getOutputStream();
                    } catch (final IOException e) {
                        e.printStackTrace();
                        runOnUiThread(() -> {
                            loading.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "连接失败:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                    }

                }

            }
        };
        thread.start();

    }


    public void send(View view) {
        data = editText_data.getText().toString();
        if (TextUtils.isEmpty(data)) {
            Toast.makeText(MainActivity.this, "please input Sending Data", Toast.LENGTH_SHORT).show();
        } else {
            //在后面加上 '\0' ,是为了在服务端方便我们去解析；
            data = data + '\0';
        }
        data = UrlTool.buildUrl(data, 1);
        Log.i("realData", "" + data);
        loading.setVisibility(View.VISIBLE);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                if (socketStatus) {
                    try {
                        outputStream.write(data.getBytes("UTF-8"));
                        outputStream.flush();
                        runOnUiThread(() -> {
                            loading.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "发送成功!", Toast.LENGTH_SHORT).show();
                        });
                    } catch (final IOException e) {
                        e.printStackTrace();
                        runOnUiThread(() -> {
                            loading.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "发送失败：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                    }

                }

            }
        };
        thread.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*关闭相应的资源*/
        try {
            if (outputStream != null) {
                outputStream.close();
            }
            if (socket != null) {

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
