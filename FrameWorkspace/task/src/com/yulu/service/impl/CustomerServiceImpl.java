package com.yulu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.yulu.entity.Customer;
import com.yulu.entity.CustomerExample;
import com.yulu.entity.PageModel;
import com.yulu.mybatis.mapper.CustomerMapper;
import com.yulu.service.CustomerService;
/**
 * 客户业务逻辑层实现类
 * @author Administrator
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService{
    /**
     * 注入属性
     */
	@Resource(name="customerMapper")
	private CustomerMapper customerMapper;

	/**
	 * 添加客户
	 * @param customer 客户
	 */
	@Override
	public void addCustomer(Customer customer) {
		// 调用DAO的添加方法
		System.out.println("service执行了addCustomer");
		customerMapper.insertSelective(customer);
	}

	@Override
	public List<Customer> findCustomer() {
		System.out.println("findCustomer执行了");
		List<Customer> list = customerMapper.selectByExample(null);
		return list;
	}
    @Override
    public int delete(long id) {
        System.out.println("findCustomer执行了");
        int result = customerMapper.deleteByPrimaryKey(id);
        return result;
    }
    @Override
    public int update(Customer customer) {
        System.out.println("findCustomer执行了");
        int result = customerMapper.updateByPrimaryKey(customer);
        return result;
    }
	@Override
	public PageModel<Customer> find(String name, Integer page, Integer rows) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        if(name != null && !"".equals(name)){
            criteria.andCustNameLike("%"+name+"%");
        }

        PageModel<Customer> pageModel = new PageModel<>();
        //1.当前页
        pageModel.setCurrentPage(page);
        //2.一页显示多少条
        pageModel.setPageSize(rows);
        //3.总记录数
        long total = customerMapper.countByExample(customerExample);
        pageModel.setTotalCount(total);
        //4.总页数
        Double num = Math.ceil(total*1.0/rows);
        pageModel.setTotalPage(num.intValue());
        //5.当前页客户的集合
        Integer start = (page-1)*rows;
        // 设置开始行
        customerExample.setStart(start);
        // 设置要获取的行数
        customerExample.setLimit(rows);
        // 条件查询获取数据
        List<Customer> list = customerMapper.selectByExample(customerExample);
        pageModel.setPageList(list);
        // 返回分页模型
        return pageModel;
	}

}
