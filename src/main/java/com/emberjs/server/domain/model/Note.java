package com.emberjs.server.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiIncludeByDefault;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import io.katharsis.resource.annotations.JsonApiToOne;
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
@JsonApiResource(type = "notes")  // 对应MongoDB的note集合
public class Note extends BaseEntity {
	
	@JsonProperty
	String title;
	
	@JsonProperty
	String content;
	
	@JsonProperty
	String tag;
	
	@JsonIgnore
	String notebookId;
	
	@JsonApiRelation(opposite = "notebooks")
	Notebook notebook;

	@Override
	public String toString() {
		return "Note [title=" + title + ", content=" + content + ", tag=" + tag + ", notebookId=" + notebookId
				+ ", notebook=" + notebook + ", id=" + id + ", updateDate=" + updateDate + ", createDate=" + createDate
				+ "]";
	}
	
}
