package com.yulu.mybatis.mapper;

import java.util.List;

import com.yulu.entity.Customer;
import com.yulu.entity.CustomerExample;
import org.apache.ibatis.annotations.Param;

/**
 * 客户持久层数据接口（后面使用hibernate实现）
 *
 */
public interface CustomerMapper {
	
	int countByExample(CustomerExample example);

	int deleteByExample(CustomerExample example);

	int deleteByPrimaryKey(Long custId);

	int insert(Customer record);

	int insertSelective(Customer record);

	List<Customer> selectByExample(CustomerExample example);

	Customer selectByPrimaryKey(Long custId);

	int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

	int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

	int updateByPrimaryKeySelective(Customer record);

	int updateByPrimaryKey(Customer record);
}
