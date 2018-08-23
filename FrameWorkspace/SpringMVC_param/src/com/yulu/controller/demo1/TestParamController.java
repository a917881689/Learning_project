package com.yulu.controller.demo1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试普通参数的Controller
 */
@Controller
public class TestParamController {
	@RequestMapping("/testParam1")
	public void testParam1(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("参数id:"+id);
	}
	/**
	 * 2.类型绑定（jsp中的键一定要与形参变量名保持一致，接收类型）
	 * @param id
	 */
	@RequestMapping("/testParam2")
	public void testParam2(Integer id) {
		System.out.println("参数id:"+id);
	}
	
	@RequestMapping("/testParam3")
	public void testParam2(@RequestParam("id") Integer ids,@RequestParam("uname") String name) {
		System.out.println("参数id:"+ids+",uname:"+name);
	}
	/**
	 * 接收get请求的中文参数
	 * @param uname
	 */
	@RequestMapping("/testParam4")
	public void testParam2( String uname) {
		// 接收的参数会出现乱码(http传输过程中使用的是 ISO-8859-1编码)
		/*new String(uname.getBytes("ISO-8859-1"),"UTF-8");
		 * 或者在tomcat服务器配置URIEncoding:UTF-8
		 * */
		System.out.println("参数id:"+uname);
	}
	
	/**
	 * 接收表单get请求参数
	 * @param uname
	 */
	@RequestMapping("/testParam5")
	public void testParam5( String uname,String pwd) {
		System.out.println("参数uname:"+uname+",pwd"+pwd);
	}
	
	/**
	 * 接收表单post请求参数
	 * post请求需要手动配置自带的编码过滤器[此过滤器只能处理post请求]
	 * org.springframework.web.filter.CharacterEncodingFilter
	 * @param uname
	 */
	@RequestMapping("/testParam6")
	public void testParam6( String uname,String pwd) {
		System.out.println("参数uname:"+uname+",pwd:"+pwd);
	}
}
