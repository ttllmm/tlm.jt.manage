package com.jt.manage.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.manage.pojo.ItemCat;
import com.jt.manage.service.ItemCatService;

@RestController
public class ItemCatCiontroller {
	@Autowired
	private ItemCatService itemCatService; 
	@RequestMapping("item/cat/list")

	public List<ItemCat> queryitemCatList(@RequestParam(defaultValue="0")Long id){
		List<ItemCat>list=itemCatService.queryCatList(id);
		return list;
		
		
		
		
	}

}
