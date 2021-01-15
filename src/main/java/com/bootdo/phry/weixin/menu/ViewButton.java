package com.bootdo.phry.weixin.menu;
/**
 * view类型的菜单
 * @author wangj
 * @email j.wang@huidutech.com.cn
 * @date 2018-09-13 15:47:49
 */
public class ViewButton extends Button {

    private String type;
    private String url;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}