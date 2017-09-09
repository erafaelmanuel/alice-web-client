package com.remswork.project.alice.web.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.remswork.project.alice.exception.ClassException;
import com.remswork.project.alice.exception.ScheduleException;
import com.remswork.project.alice.model.Schedule;
import com.remswork.project.alice.web.service.ClassServiceImpl;
import com.remswork.project.alice.web.service.ScheduleServiceImpl;

@Component
@RequestMapping(value="schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleServiceImpl scheduleService;
	@Autowired
	private ClassServiceImpl classService;
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String addSchedule(@RequestParam("day") String day,
			@RequestParam("room") String room, 
			@RequestParam("time") String time,
			@RequestParam("period") String period,ModelMap modelMap) {
		try {
		Schedule schedule = new Schedule();
			schedule.setDay(day);
			schedule.setTime(time);
			schedule.setPeriod(period);
			schedule.setRoom(room);
			schedule = scheduleService.addSchedule(schedule);
			modelMap.put("schedule", schedule);
		} catch (ScheduleException e) {
			e.printStackTrace();
		}
		return "fragment/schedule-add";
	}
	
	@RequestMapping 
	public String getScheduleListByClassId(@RequestParam("classId") long classId, ModelMap modelMap){
		try {
			Set<Schedule> scheduleList = classService.getScheduleList(classId);
			modelMap.put("scheduleList", scheduleList);
			return "schedule";
		} catch (ClassException e) {
			
			e.printStackTrace();
			return "error";
		}
		
	}
	

}
