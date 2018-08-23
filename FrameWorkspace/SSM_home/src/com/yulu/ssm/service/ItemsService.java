package com.yulu.ssm.service;

import java.util.List;

import com.yulu.ssm.pojo.Items;


public interface ItemsService {

	List<Items> findAllItems();

	void itemDelete(Integer id);
	/**
	 * 查询单个商品并回显到编辑页面
	 * @param id
	 * @return
	 */
	Items showEditUI(Integer id);

	void updateitem(Items items);

	void batchDelete(Long[] idArray);

	List<Items> queryByName(String name);

	void batchUpdate(List<Items> list);

}
