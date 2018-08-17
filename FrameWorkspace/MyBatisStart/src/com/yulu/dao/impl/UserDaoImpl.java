package com.yulu.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yulu.dao.UserDao;
import com.yulu.entity.User;
import com.yulu.util.MybatisUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		return sqlSession.insert("user.insertUser",user);
		
	}

	@Override
	public int deleteUserById(Integer id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		return sqlSession.delete("user.deleteUserById",id);
	}

	@Override
	public int updateUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		return sqlSession.update("user.updateUserById",user);
	}

	@Override
	public User findUserById(Integer id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		return sqlSession.selectOne("user.queryUserById",id);
	}

	@Override
	public List<User> findAll() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(true);
		return sqlSession.selectList("user.queryAll");
	}

}
