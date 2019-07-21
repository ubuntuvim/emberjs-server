package com.emberjs.server.service;

import java.util.List;

import com.emberjs.server.domain.Note;

public interface NoteService {
	
	/**
	 * 增加一篇笔记
	 * @param note
	 */
	Note save(Note note);
	
	/**
	 * 更新一篇笔记
	 * @param note
	 */
	Note update(String noteId, Note note);
	
	/**
	 * 根据id删除一篇笔记
	 * @param note
	 */
	long delete(String noteId);
	
	/**
	 * 根据id查询某篇笔记
	 * @param noteId
	 * @return
	 */
	Note findById(String noteId);
	
	/**
	 * 查询所有笔记
	 * @return
	 */
	List<Note> findAll();

}
