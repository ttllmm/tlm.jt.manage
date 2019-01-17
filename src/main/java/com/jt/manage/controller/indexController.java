package com.jt.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("page/{pageName}")
	public String goIndex(@PathVariable String pageName){
		
		
		return pageName;
		
		
	}

}
