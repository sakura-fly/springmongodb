package com.bob.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Scope("prototype")
@RequestMapping("/")
public class IndexMgrController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView handleUserGUIIndex(HttpServletRequest request, Exception ex){
		ModelAndView mv = new ModelAndView("index");
		 return mv;
	}

	
}
