package com.bootdo.common.enums;

import lombok.Getter;

/**
 * 用户归属
 * @author Zengcx
 * @date 2018/11/22 8:33 PM
 */
@Getter
public enum Status {
    禁用(0),正常(1);
    private Integer code;
    Status(Integer code){
        this.code = code;
    }
}
