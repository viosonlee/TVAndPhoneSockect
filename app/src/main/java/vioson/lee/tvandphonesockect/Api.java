package vioson.lee.tvandphonesockect;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public interface Api {
    @FormUrlEncoded
    @POST("/vip_pppp/baiyug.php")
//    @Headers({
//            "Host: youkus.baiyug.cn:3360",
//            "Connection: keep-alive",
//            "Content-Length: 122",
//            "Accept: application/json, text/javascript, */*; q=0.01",
//            "Origin: http://youkus.baiyug.cn:3360",
//            "X-Requested-With: XMLHttpRequest",
//            "User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36",
//            //"Content-Type: application/x-www-form-urlencoded; charset=UTF-8",
//            "Referer: http://youkus.baiyug.cn:3360/vip_pppp/index.php?url=https://www.mgtv.com/b/307960/4024850.html&type=mgtv",
//            "Accept-Encoding: gzip, deflate",
//            "Accept-Language: zh-CN,zh;q=0.8,en;q=0.6",
//            "Cookie: tj_lc=655aa5d22c61c8aaaa730e42f3593d98; tj2_lc=2129ed62bd4b5c191d5e20b6aeff446a; PHPSESSID=0h4g1mdp0scn9dl9tkjkin8li7",
//    })
    Observable<String> getUrl(@Field("id") String id, @Field("type") String type, @Field("siteuser") String siteuser, @Field("md5") String md5, @Field("hd") String hd, @Field("lg") String lg);

    @GET("/")
    Observable<String>requestForCookie();
}
