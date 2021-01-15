package com.bootdo.phry.weixin.menu;
/**
 * @author wangj
 * @email j.wang@huidutech.com.cn
 * @date 2018-09-13 15:51:06
 */
public class CommonButton extends Button {

    private String type;
    private String key;
    private Button[] sub_button;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }

}