package com.bootdo.common.enums;

import lombok.Getter;

/**
 * 用户归属
 * @author Zengcx
 * @date 2018/11/22 8:33 PM
 */
@Getter
public enum DeptSelect {
    部门(1),机构(2);
    private Integer code;
    DeptSelect(Integer code){
        this.code = code;
    }
}
