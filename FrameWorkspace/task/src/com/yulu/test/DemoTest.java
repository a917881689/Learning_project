package com.yulu.test;

import com.yulu.entity.Customer;
import com.yulu.entity.CustomerExample;
import com.yulu.entity.User;
import com.yulu.mybatis.mapper.CustomerMapper;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.service.UserService;
import com.yulu.util.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
public class DemoTest {
    /*@Resource
    private UserService userService;*/

    @Test
    public void demo() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //List<Customer> byPage = customerMapper.selectByExample(null);
        //System.out.println(byPage);
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andCustNameLike("%"+"小明"+"%");
        customerExample.setStart(2);
        customerExample.setLimit(4);
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        for (Customer customer:
        customers) {
            System.out.println(customer);
        }

    }
}
