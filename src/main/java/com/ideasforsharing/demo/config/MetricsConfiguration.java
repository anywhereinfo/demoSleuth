package com.ideasforsharing.demo.config;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

@Configuration
@EnableMetrics(proxyTargetClass = true)
public class MetricsConfiguration extends MetricsConfigurerAdapter {
    
    private final Logger log = LoggerFactory.getLogger(MetricsConfiguration.class);
    private MetricRegistry metricRegistry = new MetricRegistry();
    
    @Override
    @Bean
    public MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }
    
    @PostConstruct
    public void init() {
        Marker metricsMarker = MarkerFactory.getMarker("metrics");
        final Slf4jReporter reporter = Slf4jReporter.forRegistry(metricRegistry)
                .outputTo(LoggerFactory.getLogger("metrics"))
                .markWith(metricsMarker)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
            reporter.start(5, TimeUnit.SECONDS);
    }
    
}
