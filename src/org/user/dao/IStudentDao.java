package org.user.dao;

import org.user.entity.Student;

public interface IStudentDao {

	boolean queryByNameAndPassword(Student student);
	
	boolean addStudent(Student student);

	boolean updateAllInfoByName(Student student);
}