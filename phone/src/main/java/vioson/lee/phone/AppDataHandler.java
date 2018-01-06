package vioson.lee.phone;

import android.content.Context;

import lee.vioson.network.utils.SpUtil;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class AppDataHandler {

    private static final String IP = "ip";
    private static final String TABLE_NAME = "app_data";
    private static final String LAST_VIDEO = "last_video_id";

    public static void saveIp(Context context, String ip) {
        SpUtil.with(context)
                .saveString(TABLE_NAME, IP, ip);
    }

    public static String getIp(Context context) {
        return SpUtil.with(context)
                .getString(TABLE_NAME, IP);
    }

    public static void saveLastVideoId(Context context, String videoId) {
        SpUtil.with(context)
                .saveString(TABLE_NAME, LAST_VIDEO, videoId);
    }

    public static String getLastVideoId(Context context) {
        return SpUtil.with(context)
                .getString(TABLE_NAME, LAST_VIDEO);
    }
}
