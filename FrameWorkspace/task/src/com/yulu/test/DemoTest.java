package com.yulu.test;

import com.yulu.entity.Customer;
import com.yulu.entity.User;
import com.yulu.mybatis.mapper.CustomerMapper;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.service.UserService;
import com.yulu.util.MybatisUtil;
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
        List<Customer> byPage = customerMapper.findPageByName("小",1,1);
        System.out.println(byPage);
    }
}
