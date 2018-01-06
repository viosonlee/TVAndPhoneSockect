package vioson.lee.phone;

import vioson.lee.phone.network.Requester;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class UrlTool {

    public static String getVideoUrl(String fmt, String pno, String fid, String file) {
        return String.format("%svod.do?fmt=%s&pno=%s&fid=%s&file=%s", Requester.step2Host, fmt, pno, fid, file);
    }
}
