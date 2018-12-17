package com.async.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.async.service.AsyncService;

@RestController
public class AsyncController {
	
	@Autowired
	private AsyncService asyncService;
	
	@RequestMapping(value = "async", method = RequestMethod.GET)
	public void asyncRequest() {
		System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getThreadGroup().getName());
		asyncService.asyncServiceOne();
		asyncService.asyncServiceTwo();
	}

}
