package com.home.maxwell.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.home.maxwell.dao.AppEnvDao;
import com.home.maxwell.domains.AppEnv;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository("appEnvDao")
public class AppEnvDaoImpl extends SqlMapClientDaoSupport implements AppEnvDao{

	@Autowired
	public void setNewSqlMapClient(SqlMapClient client){
		this.setSqlMapClient(client);
	}
	
	public List<AppEnv> getAppEnvValues(String value) {
		return (List<AppEnv>)getSqlMapClientTemplate().queryForList("AppEnv.getAppEnvValues", value);
	}

}
