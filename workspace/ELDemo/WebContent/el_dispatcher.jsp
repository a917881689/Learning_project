<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>获取域中的字符串：${name};</p>
<pre>获取域中的对象属性：
	工号：${emp.id}
	姓名：${emp.name}
	薪资：￥${emp.salary}
</pre>
<pre>获取域中集合中对象的属性 (使用jstl中的forEach来循环遍历)
	工号	 姓名    薪资
	 ${list[0].id}     ${list[0].name}    ￥${list[0].salary}
	 ${list[1].id}     ${list[1].name}    ￥${list[1].salary}
</pre>
<h2>若EL使用时不指定域范围，则默认从范围最小的域中开始获取值(类似于pageContext.findAttribute(String name))
	依次request、session、application域中获取属性。</h2>
<h3 style="color:red;">设计思路：域中存放的键名尽量不要重名</h3>
</body>
</html>