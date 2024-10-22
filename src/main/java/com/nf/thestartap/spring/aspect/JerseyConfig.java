package com.nf.thestartap.spring.aspect;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		registerClasses(LoggingResource.class, HelloWorldResource.class);
	}
}
