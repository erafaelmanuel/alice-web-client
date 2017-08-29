package com.remswork.project.alice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remswork.project.alice.exception.TeacherException;
import com.remswork.project.alice.model.Teacher;
import com.remswork.project.alice.web.service.TeacherServiceImpl;

@RestController
public class TestController {
	
	@Autowired
	private TeacherServiceImpl teacherService;
	
	@RequestMapping("sample")
	public String test() {
		try {
			Teacher teacher =new Teacher();
			teacher.setFirstName("verlie");
			teacherService.updateTeacherById(1, teacher, 0);
			return "";
		} catch (TeacherException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
