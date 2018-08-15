package com.yulu.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yulu.entity.Customer;
import com.yulu.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	/*@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;*/
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Test
	public void demo4() {
		List<Customer> list = customerService.queryAll();
		System.out.println(list);
	}
	
	// @Test
	public void demo3() {
		Customer customer = new Customer();
		customer.setCust_name("赵六");
		customerService.update(customer);
	}
	// @Test
	public void demo2() {
		customerService.delete(11L);
	}
	
	// @Test
	public void demo1() {
		Customer customer = new Customer();
		customer.setCust_name("赵六");
		customerService.addCustomer(customer);
		// hibernateTemplate.save(customer);
	}
}
