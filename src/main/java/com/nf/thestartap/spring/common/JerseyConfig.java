package com.nf.thestartap.spring.common;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
class JerseyConfig extends ResourceConfig {

	JerseyConfig() {
		registerClasses(LoggingResource.class, HelloWorldResource.class);
	}
}
