package com.example.demo;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
@Configuration
public class StartScheduler {
	@Autowired
	private Scheduler scheduler;
	
	@PostConstruct
	public void startScheduler() {
	    try {
	        scheduler.start();
	    } catch (SchedulerException e) {
	        // Handle scheduler start exception
	    }
	}



}
