package com.home.maxwell.env;

import org.springframework.stereotype.Component;

@Component
public class Environment {
	
	protected EnvironType envType = EnvironType.ENVIR_DE;
	
	public EnvironType getEnvType() {
		return envType;
	}

	public void setEnvType(EnvironType envType) {
		this.envType = envType;
	}
	
	
}
