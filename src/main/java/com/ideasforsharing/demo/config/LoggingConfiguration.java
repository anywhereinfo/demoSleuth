package com.ideasforsharing.demo.config;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.contrib.jackson.JacksonJsonFormatter;
import ch.qos.logback.contrib.json.classic.JsonLayout;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.spi.ContextAwareBase;


@Configuration
@RefreshScope
public class LoggingConfiguration {
/**
    private LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    
	public LoggingConfiguration() {
		createPerfLogger(context);
		addContextListener(context);
	}
	
    private void addContextListener(LoggerContext context) {
        LogbackLoggerContextListener loggerContextListener = new LogbackLoggerContextListener();
        loggerContextListener.setContext(context);
        context.addListener(loggerContextListener);
    }
    
	private void createPerfLogger(LoggerContext context) {
		  JsonLayout layout = new JsonLayout();
	      layout.setJsonFormatter(new JacksonJsonFormatter());
	      layout.setAppendLineSeparator(true);
	      layout.setTimestampFormatTimezoneId("UTC");
	      layout.setIncludeContextName(true);
	        
	       LayoutWrappingEncoder<ILoggingEvent> layoutEncoder = new LayoutWrappingEncoder<>();
	       layoutEncoder.setLayout(layout);
	       
	       RollingFileAppender<ILoggingEvent> appender = new RollingFileAppender<>();
	       appender.setName("metrics-file");
	       appender.setContext(context);
	       appender.setEncoder(layoutEncoder);
	       appender.setFile("/Users/mbatth/code/demo/build/perf.json");
	       
	       TimeBasedRollingPolicy<ILoggingEvent> timePolicy = new TimeBasedRollingPolicy<>();
	       timePolicy.setFileNamePattern("/Users/mbatth/code/demo/build/perf.%d{yyyy-MM-dd}.gz");
	       timePolicy.setContext(context);
	       timePolicy.setMaxHistory(7);
	       timePolicy.setParent(appender);
	       timePolicy.start();
	       
	       appender.setRollingPolicy(timePolicy);
	       appender.start();
	       
	        AsyncAppender asyncLogstashAppender = new AsyncAppender();
	        asyncLogstashAppender.setContext(context);
	        asyncLogstashAppender.setName("metrics");
	        asyncLogstashAppender.setQueueSize(512);
	        asyncLogstashAppender.addAppender(appender);
	        asyncLogstashAppender.start();
	        
	        context.getLogger("ROOT").addAppender(asyncLogstashAppender);
	       
	}
	
	   class LogbackLoggerContextListener extends ContextAwareBase implements LoggerContextListener {

	        @Override
	        public boolean isResetResistant() {
	            return true;
	        }

	        @Override
	        public void onStart(LoggerContext context) {
	        		createPerfLogger(context);
	        }

	        @Override
	        public void onReset(LoggerContext context) {
	        		createPerfLogger(context);
	        }

	        @Override
	        public void onStop(LoggerContext context) {
	            // Nothing to do.
	        }

	        @Override
	        public void onLevelChange(ch.qos.logback.classic.Logger logger, Level level) {
	            // Nothing to do.
	        }
	    }
	    **/
}
