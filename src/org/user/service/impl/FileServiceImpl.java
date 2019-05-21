package org.user.service.impl;

import org.file.dao.impl.FileDaoImpl;
import org.user.entity.File;
import org.user.service.IFileService;

public class FileServiceImpl implements IFileService{
	FileDaoImpl dao = new FileDaoImpl();
	
	@Override
	public boolean add(File file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean queryFile(int fno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFile(File file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFile(File file, File newFIle) {
		// TODO Auto-generated method stub
		return false;
	}

}
