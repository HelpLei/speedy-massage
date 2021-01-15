package com.bootdo.system.vo;

import com.bootdo.system.domain.UserLoginDO;

/**
 * @author gaoyuzhe
 * @date 2017/12/15.
 */
public class UserLoginVO {
    /**
     * 更新的用户对象
     */
    private UserLoginDO userDO = new UserLoginDO();
    /**
     * 旧密码
     */
    private String pwdOld;
    /**
     * 新密码
     */
    private String pwdNew;

    public UserLoginDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserLoginDO userDO) {
        this.userDO = userDO;
    }

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld;
    }

    public String getPwdNew() {
        return pwdNew;
    }

    public void setPwdNew(String pwdNew) {
        this.pwdNew = pwdNew;
    }
}
