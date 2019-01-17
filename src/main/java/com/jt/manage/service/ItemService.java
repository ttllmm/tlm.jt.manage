package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.common.redis.RedisService;
import com.jt.common.vo.EasyUIResult;
import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;

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
	@Autowired
	private ItemDescMapper itemDescMapper;
	@Autowired 
	private RedisService redisService;
	public ItemDesc queryItemDesc(Long itemId) {
//		1.缓存中有数据直接调用缓存中的数据
		String key="item_desc"+itemId;
		if(redisService.exists(key)){
			
			String desc=redisService.get(key);
			ItemDesc itemDesc=new ItemDesc();
			itemDesc.setItemDesc(desc);
			return itemDesc;
			
		}
//		2.缓存中没数据调用数据库中的数据
		else{
		    try {
			ItemDesc exist=itemDescMapper.selectByPrimaryKey(itemId);
			if(exist==null){//1.查到id但数据库没有数据时,为了更新成功,新建个空的ItemId
				ItemDesc itemDesc=new ItemDesc();
				itemDesc.setItemId(itemId);
				itemDescMapper.insertSelective(itemDesc);
//				2.1数据库没数据，缓存什么都不存
				return itemDesc;
			}
			
//			   2.2查到id并且有数据将其存到缓存中
			redisService.set(key, exist.getItemDesc());
			return exist;
		  } catch (Exception e) {//该id不存在时,也新建一个id为itemid的空的itemdesc
			   ItemDesc itemDesc=new ItemDesc();
			   itemDesc.setItemId(itemId);
			   itemDescMapper.insertSelective(itemDesc);
			   return itemDesc;
		}
	}
		
}
//	更新商品的方法
//	1.item表中直接更新,2.itemdesc表新建后更新
	@Transactional
	public void updateItem(Item item, String desc) {
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKeySelective(item);
		
		ItemDesc itemDesc=new ItemDesc();
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(itemDesc.getCreated());
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);
//		System.out.println(itemDesc.getItemDesc());
		
	}

}
