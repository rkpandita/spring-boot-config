package com.raman.springbootconfig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Default Profile, no need to mention. We can have test, qa, prod.
// @Profile("default")
@RefreshScope
public class GreetingController {
	
	public GreetingController() {
	}

	@Value("${my.greeting}")
	private String greetingMessage;

	@Value("Static Message ")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	// SPEL - Spring Expression Language using #{}
	@Value("#{${my.db.values.map}}")
	private Map<String, String> dbValuesMap;
	
	// Using Bean
	@Autowired
	private DbSettingsBean dbSettingsBean;
	
	@GetMapping("/greeting")
	public String greeting() {
		//return greetingMessage + staticMessage + listValues + dbValuesMap;
		return greetingMessage + staticMessage + listValues + dbValuesMap + dbSettingsBean.getConnectionString() + dbSettingsBean.getHost() + dbSettingsBean.getPort();
	}
	
}
