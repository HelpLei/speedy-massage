package com.bootdo.phry.weixin.service.impl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.phry.weixin.service.WeixinService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangj
 * @email j.wang@huidutech.com.cn
 * @date 2018-09-18 13:39:34
 */
@Service("weixinService")
public class WeixinServiceImpl implements WeixinService {

 

    public WeixinServiceImpl() {

    }

	@Override
	public Map queryList(String username, Integer page, Integer limit, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String examine(Long id, Integer examineStatus, String examineRemark, String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rawstoreininstore(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rawstoreoutoutstore(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createBuy(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
