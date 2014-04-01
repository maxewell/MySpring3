package com.home.maxwell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.maxwell.domains.Person;
import com.home.maxwell.env.RtimeDbPropertiesFactoryBean;

@Controller
public class MyController2 {
	
	protected RtimeDbPropertiesFactoryBean rtimeDbPropertiesFactoryBean;
	@Autowired
	protected Person person;
	
	@RequestMapping(value="/work.so", method=RequestMethod.GET, params="name")
	public String doMethod1(String name){
		
		System.out.println("Controller: name:" + name + ":" + person.getEmail());
				
		return "myview";
	}
	
	@Autowired
	public void setRtimeDbPropertiesFactoryBean(RtimeDbPropertiesFactoryBean bean){
		rtimeDbPropertiesFactoryBean = bean;
	}
	
}
