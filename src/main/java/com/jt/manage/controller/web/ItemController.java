package com.jt.manage.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.service.ItemService;


@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/query")
	public EasyUIResult queryItem(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="20") Integer rows){
		
		EasyUIResult result=itemService.queryItem(page,rows);
		return result;
		
		
	}
	

}
