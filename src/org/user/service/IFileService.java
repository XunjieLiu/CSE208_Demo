package org.user.service;

import org.user.entity.File;

public interface IFileService {
		
		public boolean add(File file);
		
		public boolean queryFile(int fno);
		
		public boolean deleteFile(File file);
		
		public boolean updateFile(File file, File newFIle);
}


