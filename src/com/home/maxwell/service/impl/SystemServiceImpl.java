package com.home.maxwell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.maxwell.dao.AppEnvDao;
import com.home.maxwell.domains.AppEnv;
import com.home.maxwell.service.SystemService;

@Service("systemService")
public class SystemServiceImpl implements SystemService{
	//@Autowired
	protected AppEnvDao appEnvDao;
	
	public List<AppEnv> getAppConfigValues(String value) {
		return appEnvDao.getAppEnvValues(value);
	}

	public AppEnvDao getAppEnvDao() {
		return appEnvDao;
	}

	@Autowired
	public void setAppEnvDao(AppEnvDao appConfigDao) {
		this.appEnvDao = appConfigDao;
	}

}
