package com.yosakura.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.yosakura.entity.User;

public class MyTest {
	public static void main(String[] args) {
		User user = new User(1L,"张三",8888d);
		String json_u = "{\"id\":2,\"uname\":\"李四\",\"salary\":6666}";
		// 1.将任意对象转换成json字符串
		String js_user = JSON.toJSONString(user);
		// 2.将json格式字符串解析成对象
		User user2 = JSON.parseObject(json_u,User.class);
		
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(3L,"貂蝉",123d));
		list.add(new User(4L,"大乔",321d));
		list.add(new User(5L,"小乔",321d));
		list.add(new User(5L,"王元姬",321d));
		// 3.将集合转换成json格式字符串
		String json_list = JSON.toJSONString(list);
		// 4.将json格式的集合字符串转换成对象集合;
		List<User> list_json = JSON.parseArray(json_list,User.class);
		System.out.println(json_list);
		System.out.println(list_json);
		/* 总结
		 * 1.任意对象转json: JSON.toJSONString(任意对象)
		 * 2.JSON字符串转对象: JSON.parseObject(JSON字符串,对象的类)
		 * 3.json格式的集合字符串转换成对象集合; JSON.parseArray(JSON字符串,对象的类);
		 */
	}
}
