package vioson.lee.tvandphonesockect;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private ServerSocket serverSocket = null;
    private InputStream inputStream;
    private TextView textView, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.ip);
        content = findViewById(R.id.content);
        receiveData();
//        openUrl("http://disp.titan.mgtv.com/vod.do?fmt=4&pno=3001&fid=25DA111F997DC74C96145120D357BA9B&file=/c1/2017/06/13_0/25DA111F997DC74C96145120D357BA9B_20170613_1_1_947_mp4/52F424450EBAC097DF972C13244B2048.m3u8");//test
    }

    public Handler handler = new MyHandler(this);


    static class MyHandler extends Handler {
        WeakReference<MainActivity> activityWeakReference;

        MyHandler(MainActivity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = activityWeakReference.get();
            if (activity != null) {
                String url = msg.obj.toString().trim();
                switch (msg.what) {
                    case 1:
                        activity.textView.setText(url);
                        break;
                    case 2:
//                    editText_2.setText(msg.obj.toString());
//                    stringBuffer.setLength(0);
                        activity.content.setText(url);
                        activity.openUrl(url);
                        break;
                }
            }
        }
    }

    public void openUrl(String url) {
//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.VIEW");
//        Uri content_url = Uri.parse(url);
//        intent.setData(content_url);
//        startActivity(intent);
        PlayActivity.launch(this, url);
    }


    boolean socketRun = true;

    /*
    服务器端接收数据
    需要注意以下一点：
    服务器端应该是多线程的，因为一个服务器可能会有多个客户端连接在服务器上；
    */
    public void receiveData() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                /*指明服务器端的端口号*/
                try {
                    serverSocket = new ServerSocket(8000);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                GetIpAddress.getLocalIpAddress(serverSocket);

                Message message_1 = handler.obtainMessage();
                message_1.what = 1;
                message_1.obj = "IP:" + GetIpAddress.getIP() + " PORT: " + GetIpAddress.getPort();
                handler.sendMessage(message_1);

                while (socketRun) {
                    Socket socket = null;
                    try {
                        socket = serverSocket.accept();
                        inputStream = socket.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                        socketRun = false;
                    }

                    new ServerThread(socket, inputStream).start();
                }
            }
        };
        thread.start();

    }

    class ServerThread extends Thread {

        private Socket socket;
        private InputStream inputStream;


        ServerThread(Socket socket, InputStream inputStream) {
            this.socket = socket;
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            if (inputStream == null) {
                return;
            }
            int len;
            byte[] bytes = new byte[1024];

            try {
                //在这里需要明白一下什么时候其会等于 -1，其在输入流关闭时才会等于 -1，
                //并不是数据读完了，再去读才会等于-1，数据读完了，最结果也就是读不到数据为0而已；
                while ((len = inputStream.read(bytes)) != -1) {
                    byte[] resBytes = new byte[len - 1];
                    for (int i = 0; i < len; i++) {
                        if (bytes[i] != 0)
                            resBytes[i] = bytes[i];
                    }
                    String obj = new String(resBytes, "UTF-8");
                    Message message_2 = handler.obtainMessage();
                    message_2.what = 2;
                    message_2.obj = obj;
                    handler.sendMessage(message_2);
                }
                //当这个异常发生时，说明客户端那边的连接已经断开
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    inputStream.close();
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            socketRun = false;
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
