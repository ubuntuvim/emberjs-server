package com.emberjs.server.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.emberjs.server.domain.model.Notebook;
import com.emberjs.server.domain.repository.NotebookRepository;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.resource.list.ResourceList;

@Component
public class NotebookRepositoryImpl implements NotebookRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Class<Notebook> getResourceClass() {
		return Notebook.class;
	}

	@Override
	public Notebook findOne(String id, QuerySpec querySpec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceList<Notebook> findAll(Iterable<String> ids, QuerySpec querySpec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notebook> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notebook> S create(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResourceList<Notebook> findAll(QuerySpec querySpec) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
