package com.windward.sharelibrary;

/**
 * 配置分享信息
 * <p/>
 * 所有平台分享时的参数值设定
 * <p/>
 * Created by ww on 2016/1/20.
 */
public interface ShareValues {
    /**
     * QQ分享时的分享信息
     */
    String QQ_APP_ID = "22222";
    String QQ_REDIRECT_URL = "http://114.215.208.188:8082/share/";

    /**
     * 微博分享时的分享信息
     */
    String WB_APP_KEY = "157791938";
    String WB_APP_SECRET = "a08271b611856a331a2f849ed6923cfe";
    String WB_REDIRECT_URL = "http://www.sina.com";

    /**
     * 微信分享时的信息
     */
    String WX_APP_ID = "wx29b3bab0b4a080c6";
    String WX_APP_SECRET = "f2784e991ac275e65c949566a6e664e2";
    String WX_REDIRECT_URL = "http://114.215.208.188:8082/share/";

}
