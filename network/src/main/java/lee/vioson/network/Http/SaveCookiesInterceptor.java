package lee.vioson.network.Http;

import android.content.Context;

import java.io.IOException;
import java.util.HashSet;

import lee.vioson.network.utils.CookieHandler;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by viosonlee
 * on 2017/8/14.
 * for 存储cookies
 */

public class SaveCookiesInterceptor implements Interceptor {
    private Context context;

    public SaveCookiesInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (!response.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            cookies.addAll(response.headers("Set-Cookie"));
            if (cookies.size() > 1) {
                //修复重复登录的时候没有返回验证信息的bug,
                CookieHandler.saveCookies(context,cookies);
            }
        }
        return response;
    }
}
