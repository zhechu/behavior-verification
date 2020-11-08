package com.tianque.doraemon.bv.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("aj.captcha")
@Data
public class AjCaptchaProperties {

    /**
     * 滑动拼图底图路径.
     */
    private String jigsaw = "";

    /**
     * 点选文字底图路径.
     */
    private String picClick = "";


    /**
     * 右下角水印文字(我的水印).
     */
    private String waterMark = "我的水印";

    /**
     * 右下角水印字体(宋体).
     */
    private String waterFont = "宋体";

    /**
     * 点选文字验证码的文字字体(宋体).
     */
    private String fontType = "宋体";

    /**
     * 校验滑动拼图允许误差偏移量(默认5像素).
     */
    private String slipOffset = "5";

    /**
     * aes加密坐标开启或者禁用(true|false).
     */
    private Boolean aesStatus = true;

    /**
     * 滑块干扰项(0/1/2)
     */
    private String interferenceOptions = "0";

    /**
     * local缓存的阈值
     */
    private String cacheNumber = "1000";

    /**
     * 定时清理过期local缓存(单位秒)
     */
    private String timingClear = "180";

    /**
     * 缓存类型redis/local/....
     */
    private StorageType cacheType = StorageType.local;

    public enum StorageType {
        /**
         * 内存.
         */
        local,
        /**
         * redis.
         */
        redis
    }

}
