package com.ness.gamestudio.webservice;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/rest")
public class RestServiceConfig extends ResourceConfig {
	// Jersey
	public RestServiceConfig() {
		// register(ScoreRestService.class);
		packages("com.ness.gamestudio");
	}
}
