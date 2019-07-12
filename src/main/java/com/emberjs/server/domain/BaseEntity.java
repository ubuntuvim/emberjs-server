package com.emberjs.server.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * 公共实体
 * @author ubuntuvim
 *
 */
@Data
@SuppressWarnings("serial")
public class BaseEntity implements Serializable {

	@Id
	String id;
	
	@CreatedDate  // 实体创建时会自动赋值,需要在启动类中增加@EnableMongoAuditing才能生效
	Date updateDate;
	
	@CreatedDate  // 实体创建时会自动赋值,需要在启动类中增加@EnableMongoAuditing才能生效
	Date createDate;

}
