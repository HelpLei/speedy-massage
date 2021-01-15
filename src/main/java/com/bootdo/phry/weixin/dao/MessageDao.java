package com.bootdo.phry.weixin.dao;

import com.bootdo.phry.weixin.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by xyh on 2019/4/30.
 */
public interface MessageDao {
    List<SysMenuEntity> queryListWeixin(Map<String, Object> map);

}
