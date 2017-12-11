package com.ideasforsharing.demo.management.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.ideasforsharing.demo.management.model.LoggerViewModel;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

@RestController
@RequestMapping("/management")
public class LogLevelController {

	@GetMapping("/logLevels")
	public List<LoggerViewModel> getLogLevels() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		return context.getLoggerList()
				.stream()
				.map(LoggerViewModel::new)
				.collect(Collectors.toList());
	}
	
    @PutMapping("/logLevels")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeLevel(@RequestBody LoggerViewModel jsonLogger) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.getLogger(jsonLogger.getName()).setLevel(Level.valueOf(jsonLogger.getLevel()));
    }
}
