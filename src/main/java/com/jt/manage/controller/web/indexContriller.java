package com.jt.manage.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexContriller {
	
	@RequestMapping("page/{pageName}")
	public String goIndex(@PathVariable String pageName){
		
		
		return pageName;
		
		
	}

}
