package com.bootdo.common.enums;

import lombok.Getter;

/**
 * 用户归属
 * @author Zengcx
 * @date 2018/11/22 8:33 PM
 */
@Getter
public enum UserType {
    系统用户(1),录入人员(2);
    private Integer code;
    UserType(Integer code){
        this.code = code;
    }
}
