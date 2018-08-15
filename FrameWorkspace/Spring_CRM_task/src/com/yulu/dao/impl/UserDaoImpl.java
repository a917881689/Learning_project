package com.yulu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.yulu.dao.UserDao;
import com.yulu.entity.User;
/**
 * 客户的数据持久层实现类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public boolean add(User user) {
		System.out.println("dao层执行了customer"+user);
		long id = (long) hibernateTemplate.save(user);
		return id>0;
	}

	@Override
	public User login(User user) {
		System.out.println("dao层执行了login"+user);
		List<User> list = (List<User>) hibernateTemplate.find("FROM User WHERE user_code=? AND user_password=?",user.getUser_code(),user.getUser_password());
		System.out.println("list"+list);
		return list.size() == 1?list.get(0):null;
	}

}
