package com.emberjs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emberjs.server.domain.Note;
import com.emberjs.server.service.NoteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@RequestMapping("/note")
public class NoteController {

	@Autowired
	NoteService noteServiceImpl;
	
	
	@RequestMapping(path = "/notes", method = RequestMethod.GET)
	public List<Note> findAll() {
		log.info("查询所有笔记{}", noteServiceImpl.findAll());
		return noteServiceImpl.findAll();
	}
	
	@RequestMapping(path = "/note/{id}", method = RequestMethod.DELETE)
	public long deleteById(@PathVariable String id) {
		log.info("删除: {}", id);
		return noteServiceImpl.delete(id);
	}
	
	@RequestMapping("/note/{id}")
	public Note findById(@PathVariable String id) {
		log.info("查询单个数据: {}", id);
		return noteServiceImpl.findById(id);
	}
	
	@RequestMapping("/note")
	public Note create(Note note) {
		log.debug("新增笔记：{}", note);
		return noteServiceImpl.save(note);
	}
}
