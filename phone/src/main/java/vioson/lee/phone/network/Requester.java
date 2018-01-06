package vioson.lee.phone.network;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import lee.vioson.network.core.RequestFactory;
import vioson.lee.phone.pojo.Step1Data;
import vioson.lee.phone.pojo.Step2Response;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class Requester {
    private static final String step1Host = "http://pcweb.api.mgtv.com/";
    public static final String step2Host = "http://disp.titan.mgtv.com/";

    public static void stepOne(String videoId, Observer<BaseResponse<Step1Data>> observer) {
        Api api = RequestFactory.<Api>getRequester(step1Host, Api.class).getAPIForJson();
        RequestFactory.request(api.stepOne(videoId), observer);
    }

    public static void stepTwo(String path, Observer<Step2Response> observer) {
        path = path.substring(path.indexOf("?") + 1);
        String[] split = path.split("&");
        Map<String, String> params = new HashMap<>();
        for (String s : split) {
            if (!TextUtils.isEmpty(s) && s.contains("=")) {
                String[] param = s.split("=");
                if (param.length > 1) {
                    params.put(param[0], param[1]);
                }
            }
        }
        Api api = RequestFactory.<Api>getRequester(step2Host, Api.class).getAPIForJson();
        RequestFactory.request(api.stepTwo(params), observer);
    }
}
