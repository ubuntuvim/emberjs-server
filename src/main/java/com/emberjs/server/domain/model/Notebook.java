package com.emberjs.server.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;

/**
 * 笔记本实体类
 * @author ubuntuvim
 *
 */
@SuppressWarnings("serial")
@Getter
@Setter
@JsonApiResource(type = "notebooks")  // 对应MongoDB的notebook集合
public class Notebook extends BaseEntity {

	@JsonProperty
	String title;
	
	@JsonApiRelation(opposite = "notebook") // 关联笔记本下的所有笔记
	List<Note> notes = new ArrayList<>();

	@Override
	public String toString() {
		return "Notebook [title=" + title + ", notes=" + notes + "]";
	}
	
}
