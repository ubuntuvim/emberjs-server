package com.emberjs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emberjs.server.domain.Note;
import com.emberjs.server.service.NoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@RequestMapping("/note")
public class NoteController {

	@Autowired
	NoteService noteServiceImpl;
	
	
	@RequestMapping(path = "/notes", method = RequestMethod.GET)
	public String findAll() {
		try {
			List<Note> notes = noteServiceImpl.findAll();
			log.debug("查询所有笔记{}", notes);
			ObjectMapper objectMapper = new ObjectMapper();
			String notesJson = objectMapper.writeValueAsString(notes);
			log.debug("查询所有笔记,json:{}", notesJson);
			return notesJson;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "{}";
	}
	
	@RequestMapping(path = "/notes/{id}", method = RequestMethod.DELETE)
	public long deleteById(@PathVariable String id) {
		log.info("删除: {}", id);
		return noteServiceImpl.delete(id);
	}
	
	@RequestMapping(path = "/notes/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable String id) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			log.info("查询单个数据: {}", id);
			String s = objectMapper.writeValueAsString(noteServiceImpl.findById(id));
			log.debug("查询单个数据 Json: {}", s);
			return s;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "{}";
	}
	
	@RequestMapping(path = "/notes", method = RequestMethod.POST)
	public Note create(@RequestBody Note note) {
		log.debug("新增笔记：{}", note);
		return noteServiceImpl.save(note);
	}
	
	@ResponseBody
	@RequestMapping(path = "/notes/{id}", method = { RequestMethod.PATCH, RequestMethod.PUT })
	public Note update(@PathVariable String id, @RequestBody Note note) {
		note.setId(id);
		log.debug("更新笔记：{}", id);
		log.debug("更新笔记：{}", note);
		// save方法如果id相同则更新，否则插入信息的记录
		return noteServiceImpl.save(note);
	}
}
