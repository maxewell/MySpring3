package com.home.maxwell.view.menu.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuTagHandler extends TagSupport{
	
	@Override
    public int doStartTag() throws JspException {
    	try{
    		JspWriter out = pageContext.getOut();
    		out.println("This is Menu");
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	
    	return SKIP_BODY;
    }
}
