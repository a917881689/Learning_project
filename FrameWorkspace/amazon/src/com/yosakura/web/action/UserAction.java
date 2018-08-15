package com.yosakura.web.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yosakura.entity.User;
import com.yosakura.service.impl.UserServiceImpl;
import com.yosakura.util.ImageUtil;

public class UserAction extends ActionSupport implements SessionAware,ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	private User user = new User();
	private String result = null;
	private String veryCode;
	private InputStream veryCodeStream;
	private String userName;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String queryPwd () {
		// 获取信息
		System.out.println("进入");
		String uname = user.getUname();
		String email = user.getEmail();
		System.out.printf("%s == %s ==%s",uname,userName,email);
		if (uname == null || "".equals(uname) || userName == null || "".equals(userName) || email == null || "".equals(email)) {
			result = NONE;
			return SUCCESS;
		}
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.getpwd(userName,uname,email);
		if (user == null) {
			result = ERROR;
			return SUCCESS;
		}
		result = user.getPwd();
		return SUCCESS;
	}
	public String regist () {
		System.out.println("注册开始");
		// 没有通过检查参数
		if(!registerCk()) {
			return ERROR;
		}
		boolean flag = new UserServiceImpl().regist(user);
		System.out.println(flag?"注册成功":"注册失败");
		return flag?SUCCESS:ERROR;
	}
	private boolean registerCk() {
		String uname = user.getUname();
		String pwd = user.getPwd();
		Integer sex = user.getSex();
		String birthday = user.getBirthday();
		String idCard = user.getIdCard();
		String email = user.getEmail();
		String mobile = user.getMoblie();
		String address = user.getAddress();
		Integer utype = user.getUtype();
		// 2.非空验证
		if (uname == null || "".equals(uname) || pwd == null || "".equals(pwd) || idCard == null || "".equals(idCard) || 
			mobile == null || "".equals(mobile) ||  email == null || "".equals(email) || utype == null || "".equals(utype) || 
			birthday == null || "".equals(birthday) || address == null || "".equals(address) || sex == null || "".equals(sex)) {
			return false;
		}
		return true;
	}
	public InputStream getVeryCodeStream() {
		return veryCodeStream;
	}
	
	public String getvalidateCode() throws IOException {
		//利用图片工具生成图片
		//第一个参数是生成的验证码，第二个参数是生成的图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入Session
		session.put("veryCode",objs[0].toString());
		System.out.println(objs[0]);
		//将图片输出给浏览器
		BufferedImage image = (BufferedImage) objs[1];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageOutputStream imgOutput = ImageIO.createImageOutputStream(baos);
        ImageIO.write(image, "png", imgOutput);
        veryCodeStream = new ByteArrayInputStream(baos.toByteArray());
        return SUCCESS;
	}
	public String cancel () {
		// 注销只需要将session域中的登录成功后的用户移除即可;
		if (session == null || session.get("loginUser") == null) {
			System.out.println("用户未登录注销");
			return NONE;
		}
		// 从session中删除属性对
		session.remove("loginUser");
		System.out.println("用户注销登录");
		return NONE;
		
	}
	public String dialogLogin () {
		// 获取登陆参数并非空验证
		String uname = user.getUname();
		String pwd = user.getPwd();
		if (uname == null || "".equals(uname) || pwd == null || "".equals(pwd) ) {
			return ERROR;
		}
		User user = new User(uname,pwd);
		UserServiceImpl usi = new UserServiceImpl();
		User verifyUser = usi.login(user);
		if (verifyUser == null) {
			return ERROR;
		}
		// 将登陆成功的用户放入session 用来会话跟踪
		session.put("loginUser",verifyUser);
		String jsonString = JSON.toJSONString(verifyUser);
		System.out.println("用户使用模态框登录"+jsonString);
		result = jsonString;
		return SUCCESS;
	}

	public String queryUserByEmail () {
		// 1.获取ajax请求邮箱
		String email = user.getEmail();
		if (email == null || "".equals(email)) {
			result = ERROR;
			return SUCCESS;
		}
		// 2.调用业务逻辑层的验证用户名的接口
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.queryUserByEmail(email);
		// 3.根据查询的结果来返回响应
		result = user == null ? "use":"unuse";
		return SUCCESS;
	}
	
	public String queryUserByVeryCode () {
		// 1.获取ajax请求验证码
		if (veryCode == null || "".equals(veryCode)) {
			result = ERROR;
			return SUCCESS;
		}
		// 3.对比session域中的值
		String sin_veryCode = (String) session.get("veryCode");
		if (sin_veryCode == null || "".equals(veryCode)) {
			result = ERROR;
			return SUCCESS;
		}
		
		sin_veryCode = sin_veryCode.toLowerCase();
		veryCode = veryCode.toLowerCase();
		
		// 3.根据查询的结果来返回响应
		result = sin_veryCode.equals(veryCode) ? "use":"unuse";
		return SUCCESS;
	}
	
	public String queryUserByName () {
		System.out.println("进入用户名验证");
		// 1.获取ajax请求用户名
		String uname = user.getUname();
		if (uname == null || "".equals(uname)) {
			result = ERROR;
			return SUCCESS;
		}
		// 2.调用业务逻辑层的验证用户名的接口
		UserServiceImpl usi = new UserServiceImpl();
		User user = usi.queryUserByName(uname);
		// 3.根据查询的结果来返回响应
		result = user == null ? "use":"unuse";
		System.out.println(result);
		return SUCCESS;
	}
	
	public String login () {
		String uname = user.getUname();
		String pwd = user.getPwd();
		// 获取登陆参数并非空验证
		if (uname == null || "".equals(uname) || pwd == null || "".equals(pwd) ) {
			return LOGIN;
		}
		User verifyUser = new UserServiceImpl().login(user);
		if (verifyUser == null) {
			return LOGIN;	
		}
		// 将登陆成功的用户放入session 用来会话跟踪
		session.put("loginUser",verifyUser);
		System.out.println("用户登录");
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		return user;
	}
	@Override
	public void setSession(Map<String, Object> session) {
	        this.session = session;
	}
	public String getResult() {
		return result;
	}
	public void setVeryCode(String veryCode) {
		this.veryCode = veryCode;
	}
}
