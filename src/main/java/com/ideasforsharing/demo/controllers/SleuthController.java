package com.ideasforsharing.demo.controllers;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import com.codahale.metrics.annotation.Timed;

@RestController
public class SleuthController implements ApplicationListener<EmbeddedServletContainerInitializedEvent>
{
	
	private static final Logger log = LoggerFactory.getLogger(SleuthController.class);
	//@TODO: change port to w/e devops use
	private int port;
	private final Random random = new Random();
	
	@Autowired
	private RestTemplate restTemplate;
	
	
//	@Timed
	@GetMapping("/elk")
	public String  elk() throws InterruptedException {
		int apiToCall = (int) Math.floor(random.nextInt(10));
		//custom field
		log.info("log message {}", keyValue("oidc-access-key: ", apiToCall + ""));

		Thread.sleep(this.random.nextInt(1000));
		this.restTemplate
			.getForObject("http://localhost:" + this.port + "/call" + apiToCall, String.class);
		return "success: " + apiToCall;
		
	}

	@GetMapping("/call0")
	public String call0() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call1")
	public String call1() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call2")
	public String call2() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call3")
	public String call3() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call4")
	public String call4() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call5") 
	public String call5() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call6")
	public String call6() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call7")
	public String call7() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call8")
	public String call8() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call9")
	public String call9() throws InterruptedException
	{
		return doSomething();
	}
	
	@GetMapping("/call10")
	public String call10() throws InterruptedException
	{
		return doSomething();
	}

	private String doSomething() throws InterruptedException{
		int millis = this.random.nextInt(1000);
		Thread.sleep(millis);
		log.info("Inside new API call and slept for: " + millis);
		return "some response";
	}

	@Override
	public void onApplicationEvent(EmbeddedServletContainerInitializedEvent arg0) {
		// TODO Auto-generated method stub
		this.port = arg0.getEmbeddedServletContainer().getPort();
	}
	
	
}
