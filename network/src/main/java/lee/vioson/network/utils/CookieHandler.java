package lee.vioson.network.utils;

import android.content.Context;

import java.util.HashSet;

import lee.vioson.network.core.DebugLog;

/**
 * Created by viosonlee
 * on 2017/10/28.
 * for 保存cookie
 */

public class CookieHandler {
    private static final String APP_DATA_TABLE = "lee.vioson.network_data";
    private static final String COOKIE_STORE = "cookie_store";

    public static HashSet<String> getCookies(Context context) {
        DebugLog.e("读取Cookie");
        return SpUtil.with(context).getStringSet(APP_DATA_TABLE, COOKIE_STORE);
    }

    public static void saveCookies(Context context, HashSet<String> cookies) {
        SpUtil.with(context).saveStringSet(APP_DATA_TABLE, COOKIE_STORE, cookies);

        DebugLog.e("保存Cookie" + cookies.toString());
    }

    public static void clearCookie(Context context) {
        SpUtil.with(context).saveStringSet(APP_DATA_TABLE, COOKIE_STORE, new HashSet<>());
        DebugLog.e("清除Cookie");
    }
}
