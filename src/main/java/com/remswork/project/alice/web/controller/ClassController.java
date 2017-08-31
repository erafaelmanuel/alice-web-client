package com.remswork.project.alice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.remswork.project.alice.exception.ClassException;
import com.remswork.project.alice.model.Class;
import com.remswork.project.alice.web.service.ClassServiceImpl;

@Controller
@RequestMapping("class")
public class ClassController {
	
	@Autowired
	private ClassServiceImpl classService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(
			@RequestParam("teacherId") long teacherId,
			@RequestParam("subjectId") long subjectId,
			@RequestParam("sectionId") long sectionId) {
		
		Class _class = new Class();
		
		try {
			classService.addClass(_class, teacherId, subjectId, sectionId);
		} catch (ClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "nothing";
	}
}
