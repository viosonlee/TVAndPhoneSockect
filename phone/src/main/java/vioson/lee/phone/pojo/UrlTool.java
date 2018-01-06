package vioson.lee.phone.pojo;

/**
 * Created by viosonlee
 * on 2018/1/5.
 * for
 */

public class UrlTool {
    private static final String[] HEAD_URLS = {
            "http://api.baiyug.cn/vip/index.php?url=",
            "http://api.91exp.com/svip/?url=",
            "http://api.pucms.com/index.php?url=",
            "http://lookxw.com/yingzi/?url=",
            "http://api.97kn.com/?url=",
            "http://jx.ejiafarm.com/dy.php?url=",
            "http://aikan-tv.com/?url="
    };

    public static String buildUrl(String url, int index) {
        if (index > 0) {
            return HEAD_URLS[index - 1] + url;
        } else return url;
    }
}
