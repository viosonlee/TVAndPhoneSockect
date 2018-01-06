package vioson.lee.phone.pojo;

import java.util.List;

/**
 * Created by viosonlee
 * on 2018/1/6.
 * for
 */

public class Step1Data {

    /**
     * frame : {"images":["http://3img.hitv.com/preview/frame_images/pcframes/2018/yuanchuang/92186/2002503/11323609_1.jpg"],"second":["0|5|10|15|20|25|30|35|40|45|50|55|60|65|70|75|80|85|90|95|100|105|110|115|120|125|130|135|140|145|150|155|160|165|170|175|180|185|190|195|200|205|210|215|220|225|230|235|240|245|250|255|260"]}
     * info : {"buytips":"","clipLimit":1,"clip_type":"1","collection_id":"320207","collection_name":"","desc":"赵丽颖《想你》MV","duration":"261","keepPlay":null,"keepPlayType":0,"paymark":"0","playlist_id":"","playlist_name":"","price_novip":"","price_vip":"","root_id":"111","series":"第 2018-01-04 期","series_id":"0","thumb":"http://2img.hitv.com/preview/sp_images/2018/yuanchuang/320207/4234954/20180104105548143.jpg","tips":null,"title":"爱豆制片厂 2018","trialtime":"300","url":"http://www.mgtv.com/s/4234954.html","video_id":"4234954","watchTime":0}
     * points : {"content":[],"end":"","start":""}
     * share : {"dc":"af404e23-d838-484f-91cd-150c13428a4e","qq":"http://connect.qq.com/widget/shareqq/index.html?title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E&desc=%E5%9C%A8%E8%8A%92%E6%9E%9CTV%E4%B8%8A%E7%9C%8B%E8%A7%81%E8%BF%99%E6%9D%A1%E8%A7%86%E9%A2%91%E8%BF%98%E4%B8%8D%E9%94%99%E5%93%A6%EF%BC%9A%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018&site=%E8%8A%92%E6%9E%9CTV&url=http://www.mgtv.com/s/4234954.html%3Fdc%3D012efd03-b2a8-48c2-b5b5-b78ea0c1cf5a%26cxid%3D90fe36tp1&tpa=dW5pb25faWQ9MTAzMjUyXzEwMDAwMV8wMV8wMQ","qzone":"http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http://www.mgtv.com/s/4234954.html%3Fdc%3Db27af34c-072b-43f1-aad3-c41274f95dc3%26cxid%3D90fe36tp1&title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E","weibo":"http://service.weibo.com/share/share.php?appkey=152400019&url=http://www.mgtv.com/s/4234954.html%3Fdc%3D1eeb5472-f4b1-44d0-b7fc-a2d710bf9fb8%26cxid%3D94f9tkogo&title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E&content=utf-8&pic=http://2img.hitv.com/preview/sp_images/2018/yuanchuang/320207/4234954/20180104105548143.jpg","weixin":"http://www.mgtv.com/share/weixin/?url=http://www.mgtv.com/s/4234954.html%3Fdc%3D4ad79d84-447a-44a5-ae18-77cd52a0773c&title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E"}
     * stream : [{"def":"1","name":"标清","scale":"16:9","url":"/vod.do?pm=7x92n50NiYF17cHiwCwJj2RtPtAlQwAj_Uqt3rUiEYOij3f6k4iepBLgcA5290_QmuTQO0SjN8KfShuIQiYmXfBybin2xmJ_P0L1CBiQREH8UglIZHU4vc1chvZAXdADkeaSBAw01_L1JwZcNsRdubdevENitytwmwBqfb4y4WghziCrTTn0GMSvcswX2qL3hqlhrpDJ1Hjk_g4_fTRccF~KXBM-&fid=8F59798DBDA2B877408597AEFE98A27C&arange=0&gsid=05e9878e-84b7-46d5-9909-473e40a19dd0","vip":"0"},{"def":"2","name":"高清","scale":"16:9","url":"/vod.do?pm=r6eVgYtp_51d1hMVwcckwjxgGba~czbDJRJk4RFY0ftsHlGGMBYRxb9PN3j9pxTAEG_rUX8pmywy9ooT106gWMzYOgZv2KgGob8QouMspetwoJpfM_iwILJ36BGx9YsvdGm_MiZOi0GsAOZn4OVac1z6pgIn1y_Jaly7LLiu17tXgsar3Piwx0K0oyxNbfpDffX30OqEBjysowKXYqpg97OoAmA-&fid=10731D57AEB97411AB7CB66359AF9F37&arange=0&gsid=0dbcf433-691d-41aa-8887-83ba8272aeda","vip":"0"},{"def":"3","name":"超清","scale":"16:9","url":"/vod.do?pm=HYpRVr6z_VMalzc7UFyt9GzipmCIvj~Z2~lyeUHmNy5Zf8Ko2GNiDh9nVOOmliQyPfiaHfp9MtGpE3CilztE~kFhfKkvT19BSJEuaibkNbr4a8RQdunFuRTAuiurleqkR17i4e36neZKCB9uisVKxRUT~Jpav2s~E3tG~N~jiAu7vWQMg02B8_sjU1MNhZh~QvDiQx~i9BE9PXnviFZX99JSDmw-&fid=F586B1C7520921A58BA2E505A106B057&arange=0&gsid=647e2019-6cc8-4d79-982d-3e0c568d004f","vip":"0"}]
     * stream_domain : ["http://web-disp.titan.mgtv.com","http://web-disp1.titan.mgtv.com","http://web-disp2.titan.mgtv.com"]
     * stream_quality : {"default_quality":"-999","default_quality_force":"-999"}
     * user : {"cxid":"1515210948594_8kpqp21m4cm","ip":"27.18.210.207","iplimit":"0","isvip":"0","login":false,"mac":"8a98b561-fdeb-4cf4-a3f0-9975f06b0026","nickname":"","purview":"200","uuid":""}
     */

    private FrameBean frame;
    private InfoBean info;
    private PointsBean points;
    private ShareBean share;
    private StreamQualityBean stream_quality;
    private UserBean user;
    private List<StreamBean> stream;
    private List<String> stream_domain;

    public FrameBean getFrame() {
        return frame;
    }

    public void setFrame(FrameBean frame) {
        this.frame = frame;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public PointsBean getPoints() {
        return points;
    }

    public void setPoints(PointsBean points) {
        this.points = points;
    }

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }

    public StreamQualityBean getStream_quality() {
        return stream_quality;
    }

    public void setStream_quality(StreamQualityBean stream_quality) {
        this.stream_quality = stream_quality;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<StreamBean> getStream() {
        return stream;
    }

    public void setStream(List<StreamBean> stream) {
        this.stream = stream;
    }

    public List<String> getStream_domain() {
        return stream_domain;
    }

    public void setStream_domain(List<String> stream_domain) {
        this.stream_domain = stream_domain;
    }

    public static class FrameBean {
        private List<String> images;
        private List<String> second;

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<String> getSecond() {
            return second;
        }

        public void setSecond(List<String> second) {
            this.second = second;
        }
    }

    public static class InfoBean {
        /**
         * buytips :
         * clipLimit : 1
         * clip_type : 1
         * collection_id : 320207
         * collection_name :
         * desc : 赵丽颖《想你》MV
         * duration : 261
         * keepPlay : null
         * keepPlayType : 0
         * paymark : 0
         * playlist_id :
         * playlist_name :
         * price_novip :
         * price_vip :
         * root_id : 111
         * series : 第 2018-01-04 期
         * series_id : 0
         * thumb : http://2img.hitv.com/preview/sp_images/2018/yuanchuang/320207/4234954/20180104105548143.jpg
         * tips : null
         * title : 爱豆制片厂 2018
         * trialtime : 300
         * url : http://www.mgtv.com/s/4234954.html
         * video_id : 4234954
         * watchTime : 0
         */

        private String buytips;
        private int clipLimit;
        private String clip_type;
        private String collection_id;
        private String collection_name;
        private String desc;
        private String duration;
        private Object keepPlay;
        private int keepPlayType;
        private String paymark;
        private String playlist_id;
        private String playlist_name;
        private String price_novip;
        private String price_vip;
        private String root_id;
        private String series;
        private String series_id;
        private String thumb;
        private Object tips;
        private String title;
        private String trialtime;
        private String url;
        private String video_id;
        private int watchTime;

        public String getBuytips() {
            return buytips;
        }

        public void setBuytips(String buytips) {
            this.buytips = buytips;
        }

        public int getClipLimit() {
            return clipLimit;
        }

        public void setClipLimit(int clipLimit) {
            this.clipLimit = clipLimit;
        }

        public String getClip_type() {
            return clip_type;
        }

        public void setClip_type(String clip_type) {
            this.clip_type = clip_type;
        }

        public String getCollection_id() {
            return collection_id;
        }

        public void setCollection_id(String collection_id) {
            this.collection_id = collection_id;
        }

        public String getCollection_name() {
            return collection_name;
        }

        public void setCollection_name(String collection_name) {
            this.collection_name = collection_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Object getKeepPlay() {
            return keepPlay;
        }

        public void setKeepPlay(Object keepPlay) {
            this.keepPlay = keepPlay;
        }

        public int getKeepPlayType() {
            return keepPlayType;
        }

        public void setKeepPlayType(int keepPlayType) {
            this.keepPlayType = keepPlayType;
        }

        public String getPaymark() {
            return paymark;
        }

        public void setPaymark(String paymark) {
            this.paymark = paymark;
        }

        public String getPlaylist_id() {
            return playlist_id;
        }

        public void setPlaylist_id(String playlist_id) {
            this.playlist_id = playlist_id;
        }

        public String getPlaylist_name() {
            return playlist_name;
        }

        public void setPlaylist_name(String playlist_name) {
            this.playlist_name = playlist_name;
        }

        public String getPrice_novip() {
            return price_novip;
        }

        public void setPrice_novip(String price_novip) {
            this.price_novip = price_novip;
        }

        public String getPrice_vip() {
            return price_vip;
        }

        public void setPrice_vip(String price_vip) {
            this.price_vip = price_vip;
        }

        public String getRoot_id() {
            return root_id;
        }

        public void setRoot_id(String root_id) {
            this.root_id = root_id;
        }

        public String getSeries() {
            return series;
        }

        public void setSeries(String series) {
            this.series = series;
        }

        public String getSeries_id() {
            return series_id;
        }

        public void setSeries_id(String series_id) {
            this.series_id = series_id;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public Object getTips() {
            return tips;
        }

        public void setTips(Object tips) {
            this.tips = tips;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTrialtime() {
            return trialtime;
        }

        public void setTrialtime(String trialtime) {
            this.trialtime = trialtime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public int getWatchTime() {
            return watchTime;
        }

        public void setWatchTime(int watchTime) {
            this.watchTime = watchTime;
        }
    }

    public static class PointsBean {
        /**
         * content : []
         * end :
         * start :
         */

        private String end;
        private String start;
        private List<?> content;

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public List<?> getContent() {
            return content;
        }

        public void setContent(List<?> content) {
            this.content = content;
        }
    }

    public static class ShareBean {
        /**
         * dc : af404e23-d838-484f-91cd-150c13428a4e
         * qq : http://connect.qq.com/widget/shareqq/index.html?title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E&desc=%E5%9C%A8%E8%8A%92%E6%9E%9CTV%E4%B8%8A%E7%9C%8B%E8%A7%81%E8%BF%99%E6%9D%A1%E8%A7%86%E9%A2%91%E8%BF%98%E4%B8%8D%E9%94%99%E5%93%A6%EF%BC%9A%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018&site=%E8%8A%92%E6%9E%9CTV&url=http://www.mgtv.com/s/4234954.html%3Fdc%3D012efd03-b2a8-48c2-b5b5-b78ea0c1cf5a%26cxid%3D90fe36tp1&tpa=dW5pb25faWQ9MTAzMjUyXzEwMDAwMV8wMV8wMQ
         * qzone : http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=http://www.mgtv.com/s/4234954.html%3Fdc%3Db27af34c-072b-43f1-aad3-c41274f95dc3%26cxid%3D90fe36tp1&title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E
         * weibo : http://service.weibo.com/share/share.php?appkey=152400019&url=http://www.mgtv.com/s/4234954.html%3Fdc%3D1eeb5472-f4b1-44d0-b7fc-a2d710bf9fb8%26cxid%3D94f9tkogo&title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E&content=utf-8&pic=http://2img.hitv.com/preview/sp_images/2018/yuanchuang/320207/4234954/20180104105548143.jpg
         * weixin : http://www.mgtv.com/share/weixin/?url=http://www.mgtv.com/s/4234954.html%3Fdc%3D4ad79d84-447a-44a5-ae18-77cd52a0773c&title=%E6%88%91%E6%AD%A3%E5%9C%A8+%40%E8%8A%92%E6%9E%9CTV+%E7%9C%8B%E3%80%90%E7%88%B1%E8%B1%86%E5%88%B6%E7%89%87%E5%8E%82+2018%E3%80%91%E5%B0%8F%E4%BC%99%E4%BC%B4%E4%BB%AC%E9%80%9F%E5%BA%A6%E5%9B%B4%E8%A7%82%E4%BA%86%7E
         */

        private String dc;
        private String qq;
        private String qzone;
        private String weibo;
        private String weixin;

        public String getDc() {
            return dc;
        }

        public void setDc(String dc) {
            this.dc = dc;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getQzone() {
            return qzone;
        }

        public void setQzone(String qzone) {
            this.qzone = qzone;
        }

        public String getWeibo() {
            return weibo;
        }

        public void setWeibo(String weibo) {
            this.weibo = weibo;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
        }
    }

    public static class StreamQualityBean {
        /**
         * default_quality : -999
         * default_quality_force : -999
         */

        private String default_quality;
        private String default_quality_force;

        public String getDefault_quality() {
            return default_quality;
        }

        public void setDefault_quality(String default_quality) {
            this.default_quality = default_quality;
        }

        public String getDefault_quality_force() {
            return default_quality_force;
        }

        public void setDefault_quality_force(String default_quality_force) {
            this.default_quality_force = default_quality_force;
        }
    }

    public static class UserBean {
        /**
         * cxid : 1515210948594_8kpqp21m4cm
         * ip : 27.18.210.207
         * iplimit : 0
         * isvip : 0
         * login : false
         * mac : 8a98b561-fdeb-4cf4-a3f0-9975f06b0026
         * nickname :
         * purview : 200
         * uuid :
         */

        private String cxid;
        private String ip;
        private String iplimit;
        private String isvip;
        private boolean login;
        private String mac;
        private String nickname;
        private String purview;
        private String uuid;

        public String getCxid() {
            return cxid;
        }

        public void setCxid(String cxid) {
            this.cxid = cxid;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getIplimit() {
            return iplimit;
        }

        public void setIplimit(String iplimit) {
            this.iplimit = iplimit;
        }

        public String getIsvip() {
            return isvip;
        }

        public void setIsvip(String isvip) {
            this.isvip = isvip;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPurview() {
            return purview;
        }

        public void setPurview(String purview) {
            this.purview = purview;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }

    public static class StreamBean {
        /**
         * def : 1
         * name : 标清
         * scale : 16:9
         * url : /vod.do?pm=7x92n50NiYF17cHiwCwJj2RtPtAlQwAj_Uqt3rUiEYOij3f6k4iepBLgcA5290_QmuTQO0SjN8KfShuIQiYmXfBybin2xmJ_P0L1CBiQREH8UglIZHU4vc1chvZAXdADkeaSBAw01_L1JwZcNsRdubdevENitytwmwBqfb4y4WghziCrTTn0GMSvcswX2qL3hqlhrpDJ1Hjk_g4_fTRccF~KXBM-&fid=8F59798DBDA2B877408597AEFE98A27C&arange=0&gsid=05e9878e-84b7-46d5-9909-473e40a19dd0
         * vip : 0
         */

        private String def;
        private String name;
        private String scale;
        private String url;
        private String vip;

        public String getDef() {
            return def;
        }

        public void setDef(String def) {
            this.def = def;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getScale() {
            return scale;
        }

        public void setScale(String scale) {
            this.scale = scale;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVip() {
            return vip;
        }

        public void setVip(String vip) {
            this.vip = vip;
        }
    }
}
