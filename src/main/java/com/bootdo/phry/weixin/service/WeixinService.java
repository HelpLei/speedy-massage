package com.bootdo.phry.weixin.service;

import com.bootdo.phry.weixin.entity.SysMenuEntity.*;

import java.util.List;
import java.util.Map;

/**
 * @author wangj
 * @email j.wang@huidutech.com.cn
 * @date 2018-09-18 11:53:17
 */
public interface WeixinService {
    //列表数据
    Map queryList(String username, Integer page, Integer limit, String str);

    //审核
    String examine(Long id, Integer examineStatus, String examineRemark, String str);

 
    //入库
    String rawstoreininstore(Long id);

  
    //出库
    String rawstoreoutoutstore(Long id);
    //生成请购单
    String createBuy(Long id) throws Exception;


}
