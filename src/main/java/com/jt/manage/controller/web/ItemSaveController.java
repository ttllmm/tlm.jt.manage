package com.jt.manage.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemSaveService;

@RestController
public class ItemSaveController {
	@Autowired
	private ItemSaveService itemSaveService;
	@RequestMapping("item/save")
    public SysResult ItemSave(Item item,String desc){
		System.out.println("bagayalu");
		SysResult result=new SysResult();
		try {
			itemSaveService.insertItem(item,desc);
			result.setMsg("祝贺大神添加商品成功");
			result.setStatus(200);
		
			return result;
		} catch (Exception e) {
			result.setMsg("很遗憾失败咯，滚回去找bug");
			result.setStatus(201);
			return result;
		}
		
		
		
		
		
		
	}
}
