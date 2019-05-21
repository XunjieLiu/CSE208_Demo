package org.user.service.impl;

import org.user.dao.IStudentDao;
import org.user.dao.impl.StudentDaoImpl;
import org.user.entity.Student;
import org.user.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = new StudentDaoImpl();

	@Override
	public boolean queryByNameAndPassword(Student student) {
		// TODO Auto-generated method stub
		return studentDao.queryByNameAndPassword(student);
	}
	
	public boolean addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	@Override
	public boolean updateAllInfoByName(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateAllInfoByName(student);
	}
	

}
