package com.emberjs.server.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 笔记实体类
 * @author ubuntuvim
 *
 */
@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@Document(collation = "note")  // 对应MongoDB的note集合
public class Note extends BaseEntity {
	
	String tile;
	
	String content;
	
	String tag;
	
	@DBRef  // 关联到某个笔记本下
	Notebook notebook;
	
}
