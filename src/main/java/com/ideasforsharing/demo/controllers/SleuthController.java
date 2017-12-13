package com.ideasforsharing.demo.controllers;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
public class SleuthController {
	
	private static final Logger log = LoggerFactory.getLogger(SleuthController.class);
	
	@Timed
	@GetMapping("/")
	public String  helloSleuth() {
		int x = (int) Math.floor(new Random().nextInt(10));
		//custom field
		log.info("log message {}", keyValue("oidc-access-key", "fsjdfjkdhsfkdjshfdsh"));
		
		if (x%2 ==0)
		{
			log.info("Hello Sleuth");
			
		} else
		{
//			log.error("{}", keyValue("stack_trace", new RuntimeException().getStackTrace()));
			log.error("", new RuntimeException());
		}
		return "success: " + x;
		
	}
}
