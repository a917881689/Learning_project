package com.yosakura.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.yosakura.entity.User;

public class FieldTest {
	public static void main(String[] args) throws Exception {
		
		//获取私有字段_并赋值();
		// 1.加载字节码对象
		Class<?> clazz = Class.forName("com.yosakura.entity.User");
		// 怎么获取到这个类的所有属性名
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String modifier = Modifier.toString(field.getModifiers());
			// 属性名
			String name = field.getName();
			// 属性类型
			String type = field.getType().getName();
			System.out.println("修饰符："+modifier+"字段类型"+type+"字段名:"+name);
			field.setAccessible(false);
		}
				
		
	}
	public static void 获取私有字段_并赋值()
			throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
		// 1.加载字节码对象
		Class<?> clazz = Class.forName("com.yosakura.entity.User");
		// 2.获取指定的private类型的字段（需要忽略访问修饰符）
		Field f2 = clazz.getDeclaredField("uname");
		f2.setAccessible(true);
		// 获取访问修饰符
		String modifier = Modifier.toString(f2.getModifiers());
		Class<?> type = f2.getType();
		// 3.给私有属性赋值
		User user = (User)clazz.newInstance();
		f2.set(user,"嫦娥");
		f2.setAccessible(false);
		System.out.println("修饰符："+modifier+""+type+"uname:"+user.getUname());
		
	}
	//获取public字段并赋值
	public static void setFiled()
			throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
		// 1.加载字节码对象
		Class<?> clazz = Class.forName("com.yosakura.entity.User");
		// 2.获取指定public类型字段
		Field f1 = clazz.getField("utype");
		int grand = f1.getModifiers();
		// 将级别字符串转换成修饰符字符串
		String string = Modifier.toString(grand);
		System.out.println(f1.getModifiers()+"-"+f1.getType());
		
		// 3.给对象赋值
		User user = (User)clazz.newInstance();
		f1.set(user,1L);
		System.out.println(user.getUtype()==1?"管理员":"普通用户");
	}
}
