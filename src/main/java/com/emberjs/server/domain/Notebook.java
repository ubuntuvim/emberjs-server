package com.emberjs.server.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 笔记本实体类
 * @author ubuntuvim
 *
 */
@Getter
@Setter
@ToString
@Document(collation = "notebook")  // 对应MongoDB的notebook集合
public class Notebook extends BaseEntity {

	String title;

	List<String> notes = new ArrayList<>();
	
	
}
