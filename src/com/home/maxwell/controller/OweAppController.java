package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domains.OweApp;
import com.home.maxwell.domains.OweCal;
import com.home.maxwell.form.OweCalForm;
import com.home.maxwell.model.OweFacade;
import com.home.maxwell.validator.OweAppValidator;
import com.home.maxwell.validator.OweCalFormValidator;
import com.home.maxwell.validator.OweCalValidator;

@Controller
public class OweAppController {
	protected static Logger logger = LoggerFactory.getLogger("OweAppController");
	
	protected String SEESION_ATTR_OWECAL_LIST = "___OWE__CAL_LIST";
	protected String calYmView = "calYmView";
	protected String calInputView = "calInputView";
	protected OweFacade oweFacade;
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
		if (OweApp.class.isInstance(binder.getTarget())){
			binder.setValidator(new OweAppValidator());
		}else if (OweCalForm.class.isInstance(binder.getTarget())){
			OweCalFormValidator formvalidator = new OweCalFormValidator();
			formvalidator.setOweCalValidator(new OweCalValidator());
			binder.setValidator(formvalidator);
		}	
    }
	
	@RequestMapping(value="/oweApp/Show.so")
	public ModelAndView onShow(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		OweApp oweapp = new OweApp();
		
		ModelAndView mv = new ModelAndView(this.calYmView, "command", oweapp);
		return mv;
	}
	
	//use @ModelAttribute to assign "command"
	//use validated to validate the OweApp object
	@RequestMapping(value="/oweApp/QueryCalList.so")
	public ModelAndView onQueryCalList(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute("command") @Validated OweApp app, BindingResult result){
		
		if(result.hasErrors()){
			return new ModelAndView(this.calYmView, result.getModel());
		}
		
		if (session == null){
			session = request.getSession();
		}
		session.setAttribute("OWE_APP", app);
		
		OweCalForm form = new OweCalForm();
		session.setAttribute("OWE_CAL_FORM", form);
		form.setOweYm(app.getOweYm());
		//form.setOweApp(app);
				
		ModelAndView mv = new ModelAndView(this.calInputView, "command", form);
		return mv;
	}
	
	@RequestMapping(value="/oweApp/QueryOweData.so")
	public ModelAndView onQueryOweData(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute("command") @Validated OweCalForm form, BindingResult result ) throws ServletRequestBindingException{
		
		if(result.hasErrors()){
			return new ModelAndView(this.calInputView, result.getModel());
		}
		
		List<OweCal> owecallist = form.getOweCalList();
		for (OweCal cal : owecallist){
			logger.info("IDN:" + cal.getIdn() + ":" + cal.getBrdate());
		}
		
		ModelAndView mv = new ModelAndView(this.calInputView, "command", form);
		return mv;
	}
}
