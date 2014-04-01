package com.home.maxwell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.model.MyModelFacade;

@Controller
@RequestMapping("/doWork.so")
public class MyController {
	@Autowired
	protected MyModelFacade myModelFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	//public String onMethod1(String name){
	public String onMethod1(HttpServletRequest request,	HttpServletResponse response ){
		//System.out.println("Controller: name:" + name);
		myModelFacade.doModelThing1("Hello");
		
		return "myview"; 
	}
}
