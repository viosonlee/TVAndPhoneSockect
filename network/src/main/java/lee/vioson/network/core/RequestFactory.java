package lee.vioson.network.core;

import android.content.Context;
import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import lee.vioson.network.Http.LoggingInterceptor;
import lee.vioson.network.Http.MyGsonConverterFactory;
import lee.vioson.network.Http.ReadCookiesInterceptor;
import lee.vioson.network.Http.SaveCookiesInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by viosonlee
 * on 2017/10/28.
 * for 获取请求
 */

public class RequestFactory {
    public static <I> Requester<I> getRequester(String url, Class clazz) {
        return new Requester<I>(url, clazz);
    }

    public static void request(Observable observable, Observer subscriber) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static class Requester<T> {
        private static final long DEFAULT_TIME_OUT = 10 * 1000;
        private String url;
        private Class<T> iClass;
        private T api = null;

        private Requester(String url, Class<T> cls) {
            this.url = url;
            this.iClass = cls;
        }

        private T getAPI(Context context, boolean isJson) {
            if (api == null) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> {
                    if (TextUtils.isEmpty(message)) return;
                    String s = message.substring(0, 1);
                    //如果收到想响应是json才打印
                    if ("{".equals(s) || "[".equals(s)) {
                        DebugLog.e("收到响应: " + message);
                    }
                });
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                builder.addInterceptor(new LoggingInterceptor());
                if (context != null) {
                    builder.addInterceptor(new ReadCookiesInterceptor(context));//todo cookie 持久化方案二
                    builder.addInterceptor(new SaveCookiesInterceptor(context));//todo cookie 持久化方案二
                }
                builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
                builder.retryOnConnectionFailure(true);
                builder.addInterceptor(logging);
                OkHttpClient client = builder.build();


                Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
                if (isJson)
                    retrofitBuilder.addConverterFactory(MyGsonConverterFactory.create());
                else retrofitBuilder.addConverterFactory(ScalarsConverterFactory.create());
                retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
                retrofitBuilder.baseUrl(url);
                retrofitBuilder.client(client);
                Retrofit retrofit = retrofitBuilder.build();
                return retrofit.create(iClass);
            }
            return api;
        }

        public T getAPIForString() {
            return getAPI(null, false);
        }

        public T getAPIForStringSaveCookies(Context context) {
            return getAPI(null, false);
        }

        public T getAPIForJson() {
            return getAPI(null, true);
        }

        public T getAPIForJsonSaveCookies(Context context) {
            return getAPI(null, true);
        }
    }
}
