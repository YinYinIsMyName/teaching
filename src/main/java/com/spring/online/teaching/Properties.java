package com.spring.online.teaching;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Properties implements EnvironmentAware {
	private String api;

	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		this.setApi(environment.getProperty("app.url"));

	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

}
