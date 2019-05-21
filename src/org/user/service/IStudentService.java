package org.user.service;

import org.user.entity.Student;

public interface IStudentService {

	public boolean queryByNameAndPassword(Student student);

	public boolean addStudent(Student student);

	public boolean updateAllInfoByName(Student student);

}