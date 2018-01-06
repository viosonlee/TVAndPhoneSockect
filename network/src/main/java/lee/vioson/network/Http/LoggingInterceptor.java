package lee.vioson.network.Http;

import java.io.IOException;

import lee.vioson.network.core.DebugLog;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by viosonlee
 * on 2017/7/24.
 * for
 */

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        FormBody body = (FormBody) request.body();
        StringBuilder sb = new StringBuilder();
        if (body != null) {
            for (int i = 0; i < body.size(); i++) {
                sb.append(body.encodedName(i));
                sb.append("=");
                sb.append(body.encodedValue(i));
                sb.append(";");
            }
        }
        DebugLog.e(String.format("发送请求%s with %s on %s", request.url(), sb.toString(),
                request.headers().toString()));
        return chain.proceed(request);
    }

}
