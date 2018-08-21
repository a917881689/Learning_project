package com.yulu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.yulu.entity.User;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.service.UserService;
/**
 * setSqlSessionTemplate 将传统与接口进行整合
 * @author Administrator
 *
 */
public class UserServiceImpl2  implements UserService{

	public UserServiceImpl2() {
		super();
	}
	
	// 注入sqlSessionTemplate
	private SqlSessionTemplate template;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.template = sqlSessionTemplate;
	}

	/*@Resource(name="userMapper")
	private UserMapper mapper;*/
	
	@Override
	public User findUserById(Integer id) {
		/*UserMapper mapper = getSqlSession().getMapper(UserMapper.class);*/
		UserMapper mapper = template.getMapper(UserMapper.class);
		User user = new User();
		user.setId(id);
		List<User> list = mapper.findUser(user);
		return list != null && list.size() ==1?list.get(0):null;
	}

	@Override
	public List<User> findUserByName(String name) {
		return null;
	}

	@Override
	public List<User> findUserByNameAndSex(String name, String sex) {
		return null;
	}
	
}
