package com.emberjs.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emberjs.server.domain.model.Notebook;
import com.emberjs.server.service.NotebookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RestController
@Import({KatharsisConfigV3.class})
@Slf4j
public class NotebookController {

	@Autowired
	NotebookService notebookServiceImpl;
	
	@RequestMapping(path = "/notebooks", method = RequestMethod.GET)
	public List<Notebook> findAll() {
		return notebookServiceImpl.findAll();
	}
	
	@RequestMapping(path = "/notebooks/{id}", method = RequestMethod.DELETE)
	public long deleteById(@PathVariable String id) {
		log.debug("删除: {}", id);
		return notebookServiceImpl.delete(id);
	}
	
	@RequestMapping(path = "/notebooks/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable String id) {
		log.debug("查询单个数据: {}", id);
		String noteJson = null;
		try {
			Notebook nb = notebookServiceImpl.findById(id);
			log.debug("查询单个结果1：{}", nb);
			ObjectMapper mapper = new ObjectMapper();  
			noteJson = mapper.writeValueAsString(nb);
		} catch (JsonProcessingException e) {
			log.error("转换异常：", e);
		}
		log.debug("查询单个结果：{}", noteJson);
		return noteJson;
	}
	
	@RequestMapping(path = "/notebooks", method = RequestMethod.POST)
	public Notebook create(Notebook nb) {
		log.debug("新增笔记本：{}", nb);
		return notebookServiceImpl.save(nb);
	}
	
	@RequestMapping(path = "/notebooks/{id}", method = RequestMethod.PATCH)
	public Notebook update(@PathVariable String id, @RequestBody Notebook nb) {
		log.debug("更新笔记本：id={}", id);
		log.debug("更新笔记本：note={}", nb);
		return notebookServiceImpl.save(nb);
	}
}
