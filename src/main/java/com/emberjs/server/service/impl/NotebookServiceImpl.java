package com.emberjs.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.emberjs.server.domain.model.Notebook;
import com.emberjs.server.service.NotebookService;

@Service
public class NotebookServiceImpl implements NotebookService {

	// 直接使用springboot提供的类操作MongoDB
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Notebook save(Notebook note) {
		return mongoTemplate.save(note);
	}

	@Override
	public long delete(String notebookId) {
		Criteria criteria = Criteria.where("id").is(notebookId);
		Query query = new Query();
		query.addCriteria(criteria);
		// 一定要指定语言环境，否则报错。'Field 'locale' is invalid in: { locale: "note" }' 
		query.collation(Collation.of("zh"));
		return mongoTemplate.remove(query, Notebook.class).getDeletedCount();
	}

	@Override
	public Notebook findById(String notebookId) {
		return mongoTemplate.findById(notebookId, Notebook.class);
	}

	@Override
	public List<Notebook> findAll() {
		Query query = new Query();
		// 一定要指定语言环境，否则报错。'Field 'locale' is invalid in: { locale: "note" }' 
		query.collation(Collation.of("zh"));
		return mongoTemplate.find(query, Notebook.class);
	}

	@Override
	public Notebook update(Notebook note) {
		// TODO
		return null;
	}

}
