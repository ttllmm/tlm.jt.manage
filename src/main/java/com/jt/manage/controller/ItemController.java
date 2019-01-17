package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
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
//	商品编辑回显商品描述
	@RequestMapping("item/query/item/desc/{itemId}")
	public SysResult queryDesc(@PathVariable Long itemId){
		
		ItemDesc itemDesc=itemService.queryItemDesc(itemId);
		
		return SysResult.oK(itemDesc);
		
		
		
	}
//	在编辑商品点击修改时的请求链接
	@RequestMapping("item/update")
	public SysResult queryDesc(Item item,String desc){
		
		
		try {
			itemService.updateItem(item,desc);
			return SysResult.oK();
		} catch (Exception e) {
			return SysResult.build(201, "提交失败,滚回去找bugssssss");
		}
		
		
		
		
		
	}
}
