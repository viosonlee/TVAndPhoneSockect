package lee.vioson.network.core;

import android.util.Log;

import lee.vioson.network.BuildConfig;


/**
 * Created by viosonlee
 * on 2017/7/21.
 * for
 */

public class DebugLog {
    private static boolean isDebug = BuildConfig.DEBUG;
    private static final String TAG = "POKER_LOOPS";

    public static void d(String tag, String value) {
        if (isDebug) {
            Log.d(tag, value);
        }
    }

    public static void v(String tag, String value) {
        if (isDebug) {
            Log.v(tag, value);
        }
    }

    public static void i(String tag, String value) {
        if (isDebug) {
            Log.i(tag, value);
        }
    }

    public static void w(String tag, String value) {
        if (isDebug) {
            Log.w(tag, value);
        }
    }

    public static void e(String tag, String value) {
        if (isDebug) {
            Log.e(tag, value);
        }
    }

    public static void d(String value) {
        d(TAG, value);
    }

    public static void v(String value) {
        v(TAG, value);
    }

    public static void i(String value) {
        i(TAG, value);
    }

    public static void w(String value) {
        w(TAG, value);
    }

    public static void e(String value) {
        e(TAG, value);
    }
}
