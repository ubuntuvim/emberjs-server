package com.emberjs.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.emberjs.server.domain.Note;
import com.emberjs.server.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

	// 直接使用springboot提供的类操作MongoDB
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Note save(Note note) {
		return mongoTemplate.save(note);
	}

	@Override
	public long delete(String noteId) {
		Criteria criteria = Criteria.where("id").is(noteId);
		Query query = new Query();
		query.addCriteria(criteria);
		// 一定要指定语言环境，否则报错。'Field 'locale' is invalid in: { locale: "note" }' 
		query.collation(Collation.of("zh"));
		return mongoTemplate.remove(query, Note.class).getDeletedCount();
	}

	@Override
	public Note findById(String noteId) {
		return mongoTemplate.findById(noteId, Note.class);
	}

	@Override
	public List<Note> findAll() {
		Query query = new Query();
		// 一定要指定语言环境，否则报错。'Field 'locale' is invalid in: { locale: "note" }' 
		query.collation(Collation.of("zh"));
		return mongoTemplate.find(query, Note.class);
	}

	@Override
	public Note update(String noteId, Note note) {
		return mongoTemplate.save(note);
	}

}
