package com.yulu.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.yulu.entity.User;
import com.yulu.entity.UserExample;
import com.yulu.entity.UserExample.Criteria;
import com.yulu.mybatis.mapper.UserMapper;
import com.yulu.util.MybatisUtil;

class UserMapperTest {

	@Test
	void testDeleteByPrimaryKey() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int row = mapper.deleteByPrimaryKey(30);
		System.out.println();
	}

	@Test
	void testInsertSelective() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
	}

	@Test
	void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}
	@Test 
	void testSelectByExample() {
		SqlSession sqlSession = MybatisUtil.getSqlSession(false);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserExample ue = new UserExample();
		Criteria criteria = ue.createCriteria();
		/*criteria.andUsernameEqualTo("李海清");
		criteria.andAddressEqualTo("娜娜奇");*/
		// id小于20
		criteria.andIdLessThan(20);
		List<User> list = mapper.selectByExample(ue);
		for (User user : list) {
			System.out.println(user);
		}
	}
}
