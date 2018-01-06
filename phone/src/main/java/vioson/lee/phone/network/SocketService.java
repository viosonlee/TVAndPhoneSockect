package vioson.lee.phone.network;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for sockect 连接
 */

public class SocketService extends Service {
    private static OutputStream outputStream = null;
    private static Socket socket = null;
    private static boolean socketStatus = false;
    static boolean checkConnect = true;

    public static void connect(final String ip, final ConnectCallback connectCallback) {
        checkConnect = true;
        final Thread statusThread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (checkConnect) {
                    try {
                        Thread.sleep(5 * 1000);
                        if (!socket.isConnected() || socket.isClosed()) {
                            connectCallback.onDisConnected();
                            socketStatus = false;
                            checkConnect = false;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                if (!socketStatus) {
                    try {
                        socket = new Socket(ip, 8000);
                        socket.setKeepAlive(true);
                        socketStatus = true;
                        statusThread.start();
                        new Handler(Looper.getMainLooper())
                                .post(connectCallback::onConnected);
                        outputStream = socket.getOutputStream();
                    } catch (final IOException e) {
                        e.printStackTrace();
                        socketStatus = false;
                        new Handler(Looper.getMainLooper())
                                .post(() -> connectCallback.onError(e));
                    }

                }

            }
        };

        thread.start();
    }

    public interface ConnectCallback {
        void onConnected();

        void onDisConnected();

        void onError(Throwable throwable);
    }

    public interface SendCallback {
        void onSendOk();

        void onError(Throwable throwable);
    }

    public static void send(final String data, final SendCallback callback) {
        Log.i("realData", "" + data);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                if (socketStatus) {
                    try {
                        outputStream.write(data.getBytes("UTF-8"));
                        outputStream.flush();
                        new Handler(Looper.getMainLooper())
                                .post(callback::onSendOk);
                    } catch (final IOException e) {
                        e.printStackTrace();
                        new Handler(Looper.getMainLooper())
                                .post(() -> callback.onError(e));
                    }

                }

            }
        };
        thread.start();

    }

    @Override
    public void onDestroy() {
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

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
