package com.yulu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yulu.ssm.dao.ItemsMapper;
import com.yulu.ssm.pojo.Items;
import com.yulu.ssm.pojo.ItemsExample;
import com.yulu.ssm.service.ItemsService;


@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> findAllItems() {
		/*List<Items> list = itemsMapper.selectByExample(null);*/
		List<Items> list = itemsMapper.selectItemsList();
		return list;
	}

	// 删除方法
	@Override
	public void itemDelete(Integer id) {
		itemsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Items showEditUI(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateitem(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}

	@Override
	public void batchDelete(Long[] idArray) {
		itemsMapper.batchDelete(idArray);
	}

	@Override
	public List<Items> queryByName(String name) {
		ItemsExample example = new ItemsExample();
		example.createCriteria().andNameLike("%"+name+"%");
		return itemsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void batchUpdate(List<Items> list) {
		itemsMapper.batchUpdatePriceAndDetail(list);
	}
	
	
}
