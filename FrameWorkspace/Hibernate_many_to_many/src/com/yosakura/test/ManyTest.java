package com.yosakura.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yosakura.entity.Role;
import com.yosakura.entity.User;
import com.yosakura.utils.HibernateUtil;

public class ManyTest {
	// @Test
	public void demo3 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,1L);
		// 张良
		Role r1 = session.get(Role.class,1L);
		Role r2 = session.get(Role.class,3L);
		// 修改角色，先删除被修改的角色，然后将新角色添加到set<Role>中
		user.getRoles().remove(r1);
		user.getRoles().add(r2);
		tx.commit();
		session.close();
	}
	// @Test
	public void demo2 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,1L);
		// 查询数学角色
		session.get(Role.class,3L);
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println(role);
		}
		tx.commit();
		session.close();
	}
	@Test
	public void demo1 () {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		// 1.创建三个用户
		User u1 = new User("张恒");
		User u2 = new User("祖冲之");
		User u3= new User("张良");
		
		Role r1 = new Role("军事家");
		Role r2 = new Role("哲学家");
		Role r3 = new Role("数学家");
		// 3.建立双向关联关系
		
		// （1）张恒是军事家和哲学家
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		r1.getUsers().add(u1);
		r2.getUsers().add(u1);
		
		// （2）祖冲之是军事家和数学家
		u2.getRoles().add(r1);
		u2.getRoles().add(r3);
		r1.getUsers().add(u2);
		r3.getUsers().add(u2);
		
		// （2）张良是军事家和哲学家
		u3.getRoles().add(r1);
		u3.getRoles().add(r2);
		r1.getUsers().add(u3);
		r2.getUsers().add(u3);

		// 保存双向关联的关系
		session.save(u1);
		session.save(u2);
		session.save(u3);
		session.save(r1);
		session.save(r2);
		session.save(r3);
		
		tx.commit();
		session.close();
	}
	
}
