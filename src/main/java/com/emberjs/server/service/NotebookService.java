package com.emberjs.server.service;

import java.util.List;

import com.emberjs.server.domain.model.Notebook;

public interface NotebookService {
	
	/**
	 * 增加一篇笔记
	 * @param notebook
	 */
	Notebook save(Notebook notebook);
	
	/**
	 * 更新一篇笔记
	 * @param notebook
	 */
	Notebook update(Notebook notebook);
	
	/**
	 * 根据id删除一篇笔记
	 * @param notebook
	 */
	long delete(String notebookId);
	
	/**
	 * 根据id查询某篇笔记
	 * @param noteId
	 * @return
	 */
	Notebook findById(String notebookId);
	
	/**
	 * 查询所有笔记
	 * @return
	 */
	List<Notebook> findAll();

}
