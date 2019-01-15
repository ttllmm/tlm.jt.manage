package com.jt.manage.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.manage.mapper.DeleteItemMapper;
import com.jt.manage.mapper.InsertItemMapper;
import com.jt.manage.pojo.Item;

@Service
@Transactional
public class ItemDeleteService {
 @Autowired
 	private DeleteItemMapper deleteItemMapper;
	public void deleteItem(Item item) {
		
		//Long id=item.getId();
		deleteItemMapper.deleteByPrimaryKey(item);
	//	deleteItemMapper.delete(item);
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		System.out.println(item);
		
	}
	
}
