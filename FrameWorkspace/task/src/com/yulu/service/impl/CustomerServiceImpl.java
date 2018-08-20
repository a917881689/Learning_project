package com.yulu.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.yulu.entity.PageModel;
import org.springframework.transaction.annotation.Transactional;

import com.yulu.mybatis.mapper.CustomerMapper;
import com.yulu.entity.Customer;
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
		customerMapper.add(customer);
	}

	@Override
	public List<Customer> findCustomer() {
		System.out.println("findCustomer执行了");
		List<Customer> list = customerMapper.find();
		return list;
	}
    @Override
    public int delete(long id) {
        System.out.println("findCustomer执行了");
        int result = customerMapper.delete(id);
        return result;
    }
    @Override
    public int update(Customer customer) {
        System.out.println("findCustomer执行了");
        int result = customerMapper.update(customer);
        return result;
    }
	@Override
	public PageModel<Customer> find(String name, Integer page, Integer rows) {
        if(name == null || "".equals(name)){
            return findPage(page,rows);
        }
        return findPage(name,page,rows);
	}
    public PageModel<Customer> findPage(String name,Integer page, Integer rows){
        /*try {
            name = new String(name.getBytes("iso-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        System.out.println("name"+name);
        PageModel<Customer> pageModel = new PageModel<>();
        //1.当前页
        pageModel.setCurrentPage(page);
        //2.一页显示多少条
        pageModel.setPageSize(rows);
        //3.总记录数
        Long total = customerMapper.findCountByName(name);
        pageModel.setTotalCount(total);
        //4.总页数
        Double num = Math.ceil(total*1.0/rows);
        pageModel.setTotalPage(num.intValue());
        //5.当前页客户的集合
        Integer start = (page-1)*rows;
        List<Customer> list = customerMapper.findPageByName(name,start,rows);
        System.out.println(name+"---"+start+"---"+rows);
        pageModel.setPageList(list);
        return pageModel;
    }
	public PageModel<Customer> findPage(Integer page, Integer rows){
        PageModel<Customer> pageModel = new PageModel<>();
        //1.当前页
        pageModel.setCurrentPage(page);
        //2.一页显示多少条
        pageModel.setPageSize(rows);
        //3.总记录数
        Long total = customerMapper.findCount();
        pageModel.setTotalCount(total);
        //4.总页数
        Double num = Math.ceil(total*1.0/rows);
        pageModel.setTotalPage(num.intValue());
        //5.当前页客户的集合
        Integer start = (page-1)*rows;
        List<Customer> list = customerMapper.findPage(start,rows);
        pageModel.setPageList(list);
        return pageModel;
    }

}
