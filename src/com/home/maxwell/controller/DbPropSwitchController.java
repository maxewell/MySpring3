package com.home.maxwell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domains.Person;

@Controller
public class DbPropSwitchController {
	protected Person  person;

	@RequestMapping(value="/dbPropSwitch/Show.so")
	public ModelAndView onShow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return new ModelAndView("dbProperty", "command", person);
	}
	
	public Person getPerson() {
		return person;
	}
	@Autowired
	public void setPerson(Person person) {
		this.person = person;
	}
}
