package com.yulu.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.yulu.dao.UserDao;
import com.yulu.entity.User;
/**
 * SpringJdbc: JdbcDaoSupport
 * Hibernate: HibernateDaoSupport
 * Mybatis: SqlSessionDaoSupport
 *
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	@Override
	public List<User> findUserByName(String uname) {
		SqlSession sqlSession = super.getSqlSession();
		List<User> list = sqlSession.selectList("user.findName",uname);
		// sqlSession.close(); 此处不能释放资源,Sqlsession受Spring管理
		return list;
	}

	@Override
	public Integer insertUser(User user) {
		SqlSession sqlSession = super.getSqlSession();
		sqlSession.insert("user.insertUser",user);
		return user.getId();
	}
	
}
