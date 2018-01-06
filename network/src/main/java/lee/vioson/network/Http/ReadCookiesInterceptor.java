package lee.vioson.network.Http;


import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import lee.vioson.network.core.DebugLog;
import lee.vioson.network.utils.CookieHandler;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by viosonlee
 * on 2017/8/14.
 * for 读取Cookie
 */

public class ReadCookiesInterceptor implements Interceptor {
    public ReadCookiesInterceptor(Context context) {
        this.context = context;
    }

    private Context context;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> cookies = CookieHandler.getCookies(context);
        for (String cookie : cookies) {
            builder.addHeader("Cookie", cookie);
            DebugLog.i("ReadCookiesInterceptor", "addHeader:" + cookie);
        }
        return chain.proceed(builder.build());
    }

    public static String getCookies(Context context) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> hashSet = CookieHandler.getCookies(context);
        for (String s : hashSet) {
            if (!sb.toString().isEmpty()) {
                sb.append(";");
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
