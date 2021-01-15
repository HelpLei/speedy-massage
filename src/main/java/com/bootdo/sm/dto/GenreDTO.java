package com.bootdo.sm.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 个人类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Data
public class GenreDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//个人类型
	private String name;
	//0为显示，1为删除
	private Integer type;

}
