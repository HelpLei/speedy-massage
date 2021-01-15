package com.bootdo.phry.weixin.menu;

/**
 * 微信通用接口凭证
 * @author wangj
 * @email j.wang@huidutech.com.cn
 * @date 2018-09-13 15:38:29
 */

public class AccessToken {

    // 获取到的凭证
    private String token;
    // 凭证有效时间，单位：秒
    private int expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}