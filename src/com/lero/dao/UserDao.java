package com.lero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lero.model.Admin;

import com.lero.model.Qiyezhanghao;
import com.lero.model.Student;

public class UserDao {

	public Admin Login(Connection con, Admin admin)throws Exception {
		Admin resultAdmin = null;
		String sql = "select * from t_admin where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, admin.getUserName());
		pstmt.setString(2, admin.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultAdmin = new Admin();
			resultAdmin.setAdminId(rs.getInt("adminId"));
			resultAdmin.setUserName(rs.getString("userName"));
			resultAdmin.setPassword(rs.getString("password"));
			resultAdmin.setName(rs.getString("name"));
			resultAdmin.setSex(rs.getString("sex"));
			resultAdmin.setTel(rs.getString("tel"));
		}
		return resultAdmin;
	}
	
	public Qiyezhanghao Login(Connection con, Qiyezhanghao q)throws Exception {
		Qiyezhanghao resultQiyezhanghao = null;
		String sql = "select * from t_qiyezhanghao where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, q.getUserName());
		pstmt.setString(2, q.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultQiyezhanghao = new Qiyezhanghao();
			resultQiyezhanghao.setQhId(rs.getInt("qhId"));
		        resultQiyezhanghao.setPassword(rs.getString("password"));
                        resultQiyezhanghao.setUserName(rs.getString("userName"));
			int comid = rs.getInt("comid");
                        resultQiyezhanghao.setComid(comid);
			
                        resultQiyezhanghao.setMainornot(rs.getInt("mainornot"));
			
		}
		return resultQiyezhanghao;
	}
	
	public Student Login(Connection con, Student student)throws Exception {
		Student resultStudent = null;
		String sql = "select * from t_student where stuNum=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNum());
		pstmt.setString(2, student.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultStudent = new Student();
			resultStudent.setStudentId(rs.getInt("studentId"));
			resultStudent.setStuNum(rs.getString("stuNum"));
			resultStudent.setPassword(rs.getString("password"));
			int jianliId = rs.getInt("jianliId");
			resultStudent.setjianliId(jianliId);
			
			resultStudent.setEmail(rs.getString("email"));
			resultStudent.setName(rs.getString("name"));
			resultStudent.setSex(rs.getString("sex"));
			resultStudent.setTel(rs.getString("tel"));
		}
		return resultStudent;
	}
	
	public int adminUpdate(Connection con, int adminId, String password)throws Exception {
		String sql = "update t_admin set password=? where adminId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setInt(2, adminId);
		return pstmt.executeUpdate();
	}
	
	public int qUpdate(Connection con, int qhId, String password)throws Exception {
		String sql = "update t_qiyezhanghao set password=? where qhId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setInt(2, qhId);
		return pstmt.executeUpdate();
	}
	
	public int studentUpdate(Connection con, int studentId, String password)throws Exception {
		String sql = "update t_student set password=? where studentId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setInt(2, studentId);
		return pstmt.executeUpdate();
	}
	
}
