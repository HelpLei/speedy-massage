package com.bootdo.phry.weixin.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import com.bootdo.phry.weixin.menu.AccessToken;
import com.bootdo.phry.weixin.menu.Button;
import com.bootdo.phry.weixin.menu.CommonButton;
import com.bootdo.phry.weixin.menu.Menu;
import com.bootdo.phry.weixin.menu.ViewButton;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author wangj
 * @email j.wang@huidutech.com.cn
 * @date 2018-09-13 14:57:54
 */
public class MenuManager {

    private static Logger logger = LoggerFactory.getLogger(MenuManager.class);

    public static void main(String[] args) throws JSONException {

        // 调用接口获取access_token
        AccessToken at = WeixinUtil.getAccessToken(WeixinUtil.APPID, WeixinUtil.APP_SECRECT);
        System.out.println(at.getToken());

        if (null != at) {
            // 调用接口创建菜单
            // 判断菜单创建结果
            int result = WeixinUtil.createMenu(getMenu(), at.getToken());
            if (0 == result) {
                logger.info("菜单创建成功！");
                logger.info(at.getToken());
            } else {
                logger.info("菜单创建失败，错误码：" + result);
            }

        }

    }
    private static Menu getMenu() {

        String url_path1="https://172.16.0.56:8080/cyt/login.html";
        String redirect_url = "https://172.16.0.56:8080/cyt/login.html";

        String url_path2 = "";
        try{
            url_path2 = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                    + "appid=wx9bf781926a2973a0&redirect_uri="+ URLEncoder.encode(redirect_url,"UTF-8")+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
//                System.out.println("---------------------------------------------------"+url_path2);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        ViewButton mainBtn1 = new ViewButton();
        mainBtn1.setName("一级菜单");
        mainBtn1.setType("view");
        mainBtn1.setUrl(url_path1);

        ViewButton mainBtn2 = new ViewButton();
        mainBtn2.setName("一级菜单2");
        mainBtn2.setType("view");
        mainBtn2.setUrl(url_path2);

        //二级菜单
        ViewButton btn21 = new ViewButton();
        btn21.setName("🔨二级菜单");
        btn21.setType("view");
        btn21.setUrl(url_path1);

        ViewButton btn22 = new ViewButton();
        btn22.setName("❗二级菜单");
        btn22.setType("view");
        btn22.setUrl(url_path1);

        CommonButton mainBtn3 = new CommonButton();
        mainBtn3.setName("一级菜单3");
        mainBtn3.setSub_button(new Button[] {btn21 ,btn22});

        Menu menu = new Menu();
//        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
        menu.setButton(new Button[] { mainBtn1 ,mainBtn2 ,mainBtn3 });

        return menu;
    }
}
