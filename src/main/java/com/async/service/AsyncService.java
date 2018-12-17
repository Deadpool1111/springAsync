package com.async.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
	
	@Autowired
	private Executor someExecutor;
	
	
	@Async("someExecutor")
	public Future<String> asyncServiceOne() {
		
		return CompletableFuture.supplyAsync(()->{
			System.out.println();
			
		System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getThreadGroup());
		
		System.out.println();
			return "hello";
		});		
	}
	
	@Async
	public Future<String> asyncServiceTwo() {
		
		return CompletableFuture.supplyAsync(()->{
			System.out.println();
			
		System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getThreadGroup());
		
		System.out.println();
			return "hello";
		},someExecutor);		
	}

}
