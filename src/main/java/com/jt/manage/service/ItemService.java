package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;

@Service
public class ItemService {
	@Autowired
	private ItemMapper itemMapper;

	public EasyUIResult queryItem(Integer page, Integer rows) {
		
		Integer total=itemMapper.selectCount(null);
		EasyUIResult result=new EasyUIResult();
		result.setTotal(total);
		int start=(page-1)*rows;
		List<Item> itemlist=itemMapper.queryAllByPage(start,rows);
		
		result.setRows(itemlist);
		
		return result;
	}

}
