package com.ideasforsharing.demo.controllers;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SleuthController {
	
	private static final Logger log = LoggerFactory.getLogger(SleuthController.class);
	
	@GetMapping("/")
	public String  helloSleuth() {
		int x = (int) Math.floor(new Random().nextInt(10));
		if (x%2 ==0)
		{
			log.info("Hello Sleuth");
			return "success";
		} else
			throw new RuntimeException();
		
	}
}
