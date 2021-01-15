package com.bootdo.common.controller;

import com.bootdo.system.domain.UserLoginDO;
import com.bootdo.system.domain.UserToken;
import org.springframework.stereotype.Controller;
import com.bootdo.common.utils.ShiroUtils;

@Controller
public class BaseController {
	public UserLoginDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}