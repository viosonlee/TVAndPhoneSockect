package vioson.lee.tvandphonesockect;

import android.content.Context;

import lee.vioson.network.core.BaseObserver;
import lee.vioson.network.core.RequestFactory;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class Requester {
    private static final String URL = "http://youkus.baiyug.cn:3360";
    private static final String HOME_URL = "http://youkus.baiyug.cn";

    private static Api getApi(Context context) {
        return RequestFactory.<Api>getRequester(URL, Api.class)
                .getAPIForStringSaveCookies(context);
    }

    public static void getRealUrl(Context context, String id, String type, String siteuser, String md5, String hd, String lg, BaseObserver observer) {
        RequestFactory.request(getApi(context).getUrl(id, type, siteuser, md5, hd, lg), observer);
    }

    public static void requestForCookie(Context context) {
        Api api = RequestFactory.<Api>getRequester(HOME_URL, Api.class)
                .getAPIForStringSaveCookies(context);
        RequestFactory.request(api.requestForCookie(), new BaseObserver() {
            @Override
            protected void onHandleSuccess(Object data) {

            }

            @Override
            public void onNext(Object o) {

            }
        });
    }
}
