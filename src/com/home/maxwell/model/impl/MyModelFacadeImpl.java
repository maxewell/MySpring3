package com.home.maxwell.model.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.maxwell.dao.AppEnvDao;
import com.home.maxwell.domains.AppEnv;
import com.home.maxwell.model.MyModelFacade;

@Service("myModelFacade")
public class MyModelFacadeImpl implements MyModelFacade{
	protected static Logger logger = LoggerFactory.getLogger(MyModelFacadeImpl.class);
	
	protected AppEnvDao appEnvDao;
	
	public void doModelThing1(String name) {
		System.out.println("name:" + name);
		List<AppEnv> list = this.appEnvDao.getAppEnvValues("MySpring1");
		for(AppEnv bean: list){
			logger.info(bean.getEnvKey() + ":" + bean.getEnvValue());
		}
	}

	@Autowired
	public void setAppEnvDao(AppEnvDao dao){
		this.appEnvDao = dao;
	}
}
