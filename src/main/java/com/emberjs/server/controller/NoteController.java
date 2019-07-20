package com.emberjs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emberjs.server.domain.model.Note;
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
	
	
//	@RequestMapping(path = "/notes", method = RequestMethod.GET)
//	public String findAll() {
//		String noteJson = null;
//		try {
//			List<Note> notes = noteServiceImpl.findAll();
//			ObjectMapper mapper = new ObjectMapper();  
//			noteJson = mapper.writeValueAsString(notes);
//		} catch (JsonProcessingException e) {
//			log.error("Json转换异常：", e);
//		}  
//		log.info("查询所有笔记{}", noteJson);
//		return noteJson;
//	}
	
	@RequestMapping(path = "/notes", method = RequestMethod.GET)
	public List<Note> findAll() {
		return noteServiceImpl.findAll();
	}
	
	@RequestMapping(path = "/notes/{id}", method = RequestMethod.DELETE)
	public long deleteById(@PathVariable String id) {
		log.debug("删除: {}", id);
		return noteServiceImpl.delete(id);
	}
	
	@RequestMapping(path = "/notes/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable String id) {
		log.debug("查询单个数据: {}", id);
		String noteJson = null;
		try {
			Note note = noteServiceImpl.findById(id);
			log.debug("查询单个结果1：{}", note);
			ObjectMapper mapper = new ObjectMapper();  
			noteJson = mapper.writeValueAsString(note);
		} catch (JsonProcessingException e) {
			log.error("转换异常：", e);
		}
		log.debug("查询单个结果：{}", noteJson);
		return noteJson;
	}
	
	@RequestMapping(path = "/notes", method = RequestMethod.POST)
	public Note create(Note note) {
		log.debug("新增笔记：{}", note);
		
		return null;
//		return noteServiceImpl.save(note);
	}
	
	@RequestMapping(path = "/notes/{id}", method = RequestMethod.PATCH)
	public Note update(@PathVariable String id, @RequestBody Note note) {
		log.debug("更新笔记：id={}", id);
		log.debug("更新笔记：note={}", note);
		return noteServiceImpl.save(note);
	}
}
