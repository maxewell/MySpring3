package com.home.maxwell.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domains.Person;

@Controller
@RequestMapping(value="/customer/*")
public class CustomerController {
	private Person person;

	@RequestMapping(value="/customer/AddCustomer.so", method=RequestMethod.GET )
	public ModelAndView onAddCustomer(HttpServletRequest request,
		HttpServletResponse response, Person inperson) throws Exception {
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		
		session.setAttribute("custmsg", person.getFirstName() + ":" + person.getLastName() + 
				":" + person.getEmail() + ":" + person.getCar());
		
		return new ModelAndView("CustomerPage", "msg","add() method");
			
	}
	
	@RequestMapping(value="/customer/DeleteCustomer.so", method=RequestMethod.GET )
	public ModelAndView onDeleteCustomer(HttpServletRequest request,
		HttpServletResponse response, HttpSession session, Person inperson) throws Exception {
		//HttpSession session = request.getSession();
		session.setAttribute("custmsg", person.getFirstName() + ":" + person.getLastName() + 
				":" + person.getEmail() + ":" + person.getCar());
		
		return new ModelAndView("CustomerPage", "msg","delete() method");	
	}
	
	@RequestMapping(value="/customer/UpdateCustomer.so", method=RequestMethod.GET )
	public ModelAndView onUpdateCustomer(HttpServletRequest request,
		HttpServletResponse response, HttpSession session, Person inperson) throws Exception {
		//HttpSession session = request.getSession();
		session.setAttribute("custmsg", person.getFirstName() + ":" + person.getLastName() + 
				":" + person.getEmail() + ":" + person.getCar());
		
		return new ModelAndView("CustomerPage", "msg","Update() method");	
	}
	
	//
	@RequestMapping(value="/customer/ListCustomer.so", method=RequestMethod.GET )
	public ModelAndView onListCustomer(HttpServletRequest request,
		HttpServletResponse response, HttpSession session, Person inperson) throws Exception {
		//HttpSession session = request.getSession();
		session.setAttribute("custmsg", person.getFirstName() + ":" + person.getLastName() + 
				":" + person.getEmail() + ":" + person.getCar());
		
		return new ModelAndView("CustomerPage", "msg","List() method");	
	}
	
	@Autowired
	public void setPerson(Person person){
		this.person = person;
	}
}
