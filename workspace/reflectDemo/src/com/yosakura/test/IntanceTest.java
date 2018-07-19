package com.yosakura.test;

import java.lang.reflect.Constructor;

import org.junit.Test;

import com.yosakura.entity.User;

public class IntanceTest {
	/**
	 * 获取构造方法
	 * @throws Exception
	 */
	@Test
	public void getConstructer () throws Exception {
		// 1>获取字节码对象
		Class<?> clazz = Class.forName("com.yosakura.entity.User");
		// 2>获取无参数构造方法
		Constructor<?> wucan = clazz.getConstructor();
		User u = (User)wucan.newInstance();
		System.out.println(u);
		// 3>获取两参数构造方法
		Constructor<?> ercan = clazz.getConstructor(String.class,String.class);
		User u2 = (User)ercan.newInstance("张三","666");
		System.out.println(u2);
		// 4>获取三参数构造方法
		Constructor<?> sancan = clazz.getConstructor(Long.class,String.class,String.class);
		User u3 = (User)sancan.newInstance(3L,"嫦娥","666");
		System.out.println(u3);
		// 5>获取私有的构造方法(一般是获取不到的，但反射可以做到)
		Constructor<?> siyou = clazz.getDeclaredConstructor(Long.class,String.class);
		// 
		// 默认获取的是public的构造方法
		// Declared 忽略一切访问修饰符
		// java.lang.IllegalArgumentException: wrong number of arguments 非法访问 程序会自动检查访问异常 
		// 关闭程序的自动检查功能 (严重破坏封装性)
		siyou.setAccessible(true);
		User u4 = (User)siyou.newInstance(3L,"嫦娥");
		siyou.setAccessible(false);
		System.out.println(u4);
	}
	/**
	 * 1.通过字节码新建对象
	 */
	@Test //单元测试
	public void getInstance () {
		// 现在只有Class字节码文件,如何通过字节码创建对象
		// 1>获取字节码对象
		try {
			Class<?> clazz = Class.forName("com.yosakura.entity.User");
			Object obj = clazz.newInstance();
			if (obj instanceof com.yosakura.entity.User) {
				User user = (User)obj; //对象创建后就可以正常使用了
				System.out.println(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
