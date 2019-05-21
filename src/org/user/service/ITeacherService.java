package org.user.service;

import org.user.entity.Teacher;

public interface ITeacherService {

	public boolean queryByNameAndPassword(Teacher teacher);

}