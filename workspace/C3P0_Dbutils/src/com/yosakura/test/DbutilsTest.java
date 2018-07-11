package com.yosakura.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.yosakura.entity.Student;
import com.yosakura.util.C3P0Util;

/**
 * Dbutils工具的使用
 * 核心：通用的查询对象:new QueryRunner对象
 * qr对象共用 update (添加删除更新通用) query(查询)
 *
 */
public class DbutilsTest {
	public static void main(String[] args) throws SQLException {
		// queryAllStudent(); // 查询全部
		// queryStudentByName(); //根据名字查询
		// queryStudentMohu();
		// addStudent();
		// updateStudent();
		// deleteStudent();
		// sumaryFunction(); // 统计函数
	}

	public static void sumaryFunction() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT count(*) FROM student";
		long count = qr.query(sql, new ScalarHandler<>());
		System.out.println("总数:"+count);
	}

	public static void deleteStudent() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "DELETE FROM student WHERE sname=?";
		int rows = qr.update(sql,"马超2");
		System.out.println(rows>0?"删除成功":"删除失败");
	}

	public static void updateStudent() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "UPDATE student set sname = ? where sname=?";
		int rows = qr.update(sql,"马超2","马超");
		System.out.println(rows>0?"更新成功":"更新失败");
	}

	public static void addStudent() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "insert into student(sname,age,gender,birthday,cid) values(?,?,?,now(),?);";
		Object[] params = {"马超",16,"男",1}; 
		int rows = qr.update(sql,params);
		System.out.println(rows>0?"添加成功":"添加失败");
	}

	public static void queryStudentMohu() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT sname,age,gender,birthday,cid FROM student WHERE sname like ?";
		// 查询姓张的所有人
		List<Student> list = qr.query(sql,new BeanListHandler<Student>(Student.class),"张%");
		// 一般模糊查询都是 %内容%
		System.out.println(list);
	}

	public static void queryStudentByName() throws SQLException {
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT sname,age,gender,birthday,cid FROM student WHERE sname=?"; //学生对象Bean
		Student zhaoyun = qr.query(sql,new BeanHandler<Student>(Student.class),"赵云");
		System.out.println(zhaoyun);
	}

	public static void queryAllStudent() throws SQLException {
		// 1.获取数据源
		QueryRunner qr = C3P0Util.getQueryRunner();
		String sql = "SELECT sname,age,gender,birthday,cid FROM student"; 
		// 学生对象Bean的集合List
		List<Student> list = qr.query(sql,new BeanListHandler<Student>(Student.class));
		System.out.println(list);
	}
}
