package com.home.maxwell.service;

import java.util.List;
import java.util.Map;

import com.home.maxwell.domains.AppEnv;

public interface SystemService {
	public List<AppEnv> getAppConfigValues(String value);
}
