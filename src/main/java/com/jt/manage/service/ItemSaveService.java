package com.jt.manage.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.manage.mapper.DescMapper;
import com.jt.manage.mapper.InsertItemMapper;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;

@Service
@Transactional
public class ItemSaveService {
 @Autowired
 	private InsertItemMapper insertItemMapper;
 @Autowired
 private DescMapper descMapper;
	public void insertItem(Item item,String desc) {
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		insertItemMapper.insertSelective(item);
//		System.out.println(item);
//		封装itemDesc 的数据
//		持久层新增数据后，内存对象主键执行select
//		会获取当前线程最后新增数据的id值
		ItemDesc itemDesc=new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(itemDesc.getCreated());
		descMapper.insertSelective(itemDesc);
		
		
	}

}
