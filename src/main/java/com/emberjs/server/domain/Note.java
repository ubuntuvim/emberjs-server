package com.emberjs.server.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * 笔记实体类
 * @author ubuntuvim
 *
 */
@SuppressWarnings("serial")
@Getter
@Setter
@Document(collation = "note")  // 对应MongoDB的note集合
public class Note extends BaseEntity {
	
	String title;
	
	String content;
	
	String tag;
	
//	@DBRef  // 关联到某个笔记本下
	String notebookId;

	@Override
	public String toString() {
		return "Note [title=" + title + ", content=" + content + ", tag=" + tag + ", notebookId=" + notebookId + ", id="
				+ id + ", updateDate=" + updateDate + ", createDate=" + createDate + "]";
	}
}
