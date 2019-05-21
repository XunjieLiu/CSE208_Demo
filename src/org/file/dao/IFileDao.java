package org.file.dao;

import java.util.List;

import org.user.entity.File;

public interface IFileDao {
	
	public boolean addFile(File file);
	
	public boolean deleteFile(int id);
	
	public List<File> queryAllFile();
	
	public List<File> queryFileByName();
	
}
