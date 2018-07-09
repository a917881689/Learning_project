package com.yosakura.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yosakura.entity.User;
import com.yosakura.service.impl.RegisterServiceImpl;

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 ServletContext sc = req.getServletContext();
		System.out.println("sc=" + sc);
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); 
		String userName = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String idCard = req.getParameter("idCard");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		//System.out.printf("%s,%s,%s,%s,%s",userName,pwd,idCard,mobile,email);
		User user = new User(userName,pwd,idCard,mobile,email,0);
		
		int result = new RegisterServiceImpl().register(user);
		
		if (result == 1) {
			System.out.println("注册成功");
		}else {
			System.out.println("注册失败");
		}
		// ServletContext sc = req.getSession().getServletContext();
//		ServletContext sc = this.getServletContext();
//        System.out.println("sc=" + sc);
//        resp.getWriter().write("123451");
//        String path = sc.getRealPath("/WEB-INF/classes/tomca.txt");
//        System.out.println("path=" + path);
//		String info = req.getParameter("uname");
//		String info = RegisterServlet.ReadAsChars(req);
//		System.out.println("info :"+info);
//		String header = req.getHeader("User-Agent");
//        System.out.println(header);
//        //2、获得所有的头的名称
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String headerName = headerNames.nextElement();
//            String headerValue = req.getHeader(headerName);
//            System.out.println(headerName+"::"+headerValue);
//        }
	}
	@Override
	public void init() throws ServletException {
		System.out.println("RegisterServlet 初始化");
	}
//    public static String ReadAsChars(HttpServletRequest request)
//    {
// 
//        BufferedReader br = null;
//        StringBuilder sb = new StringBuilder("");
//        try
//        {
//            br = request.getReader();
//            String str;
//            while ((str = br.readLine()) != null)
//            {
//                sb.append(str);
//            }
//            br.close();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally
//        {
//            if (null != br)
//            {
//                try
//                {
//                    br.close();
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return sb.toString();
//    }
}
