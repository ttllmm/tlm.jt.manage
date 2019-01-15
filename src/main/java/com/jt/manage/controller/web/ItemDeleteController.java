package com.jt.manage.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemDeleteService;
import com.jt.manage.service.ItemSaveService;

@RestController
public class ItemDeleteController {
	@Autowired
	private ItemDeleteService itemDeleteService;
	@RequestMapping("item/delete")
    public SysResult ItemSave(Item item){
		System.out.println("bagayalu");
		SysResult result=new SysResult();
		try {
			itemDeleteService.deleteItem(item);
			result.setMsg("祝贺大神删除商品成功");
			result.setStatus(200);
			return result;
		} catch (Exception e) {
			result.setMsg("很遗憾删除失败咯，滚回去找bug");
			result.setStatus(201);
			return result;
		}
		
		
		
		
		
		
	}
}
