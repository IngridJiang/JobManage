package com.lero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.lero.model.Student;
import com.lero.util.StringUtil;

public class StudentDao {

//	public List<Student> studentList(Connection con, PageBean pageBean, Student s_student)throws Exception {
//		List<Student> studentList = new ArrayList<Student>();
//		StringBuffer sb = new StringBuffer("select * from t_student t1");
//		if(StringUtil.isNotEmpty(s_student.getName())) {
//			sb.append(" and t1.name like '%"+s_student.getName()+"%'");
//		} else if(StringUtil.isNotEmpty(s_student.getStuNumber())) {
//			sb.append(" and t1.stuNum like '%"+s_student.getStuNumber()+"%'");
//		} else if(StringUtil.isNotEmpty(s_student.getDormName())) {
//			sb.append(" and t1.dormName like '%"+s_student.getDormName()+"%'");
//		}
//		if(s_student.getDormBuildId()!=0) {
//			sb.append(" and t1.dormBuildId="+s_student.getDormBuildId());
//		}
//		if(pageBean != null) {
//			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
//		}
//		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()) {
//			Student student=new Student();
//			student.setStudentId(rs.getInt("studentId"));
//			int dormBuildId = rs.getInt("dormBuildId");
//			student.setDormBuildId(dormBuildId);
//			student.setDormBuildName(DormBuildDao.dormBuildName(con, dormBuildId));
//			student.setDormName(rs.getString("dormName"));
//			student.setName(rs.getString("name"));
//			student.setSex(rs.getString("sex"));
//			student.setStuNumber(rs.getString("stuNum"));
//			student.setTel(rs.getString("tel"));
//			student.setPassword(rs.getString("password"));
//			studentList.add(student);
//		}
//		return studentList;
//	}
	
	public List<Student> studentList(Connection con, Student s_student)throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		StringBuffer sb = new StringBuffer("select * from t_student t1");
		if(StringUtil.isNotEmpty(s_student.getName())) {
			sb.append(" and t1.name like '%"+s_student.getName()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getStuNum())) {
			sb.append(" and t1.stuNum like '%"+s_student.getStuNum()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getEmail())) {
			sb.append(" and t1.email like '%"+s_student.getEmail()+"%'");
		}else if(StringUtil.isNotEmpty(s_student.getSex())) {
			sb.append(" and t1.sex like '%"+s_student.getSex()+"%'");
                }else if(StringUtil.isNotEmpty(s_student.getTel())) {
			sb.append(" and t1.tel like '%"+s_student.getTel()+"%'");
                }else if(StringUtil.isNotEmpty(s_student.getCity())) {
			sb.append(" and t1.city like '%"+s_student.getCity()+"%'");
                } else if(StringUtil.isNotEmpty(s_student.getPassword())) {
			sb.append(" and t1.password like '%"+s_student.getPassword()+"%'");}
                    
		
			
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Student student=new Student();
			student.setStudentId(rs.getInt("studentId"));
                        student.setjianliId(rs.getInt("jianliid"));
			student.setEmail(rs.getString("email"));
			student.setName(rs.getString("name"));
			student.setSex(rs.getString("sex"));
			student.setStuNum(rs.getString("stuNum"));
			student.setTel(rs.getString("tel"));
			student.setPassword(rs.getString("password"));
                        student.setCity(rs.getString("city"));
			studentList.add(student);
		}
		return studentList;
                
	
	}
	
	public boolean haveNameByNumber(Connection con, String stuNum)throws Exception {
		String sql = "select * from t_student t1 where t1.stuNum=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, stuNum);
		ResultSet rs=pstmt.executeQuery();
		Student student = new Student();
		if(rs.next()) {
			student.setName(rs.getString("name"));
			
			
			return true;
		}
		return false;
	}
	
	
	
	
	
	public int studentCount(Connection con, Student s_student)throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from t_student t1");
		if(StringUtil.isNotEmpty(s_student.getName())) {
			sb.append(" and t1.name like '%"+s_student.getName()+"%'");
		} else if(StringUtil.isNotEmpty(s_student.getStuNum())) {
			sb.append(" and t1.stuNum like '%"+s_student.getStuNum()+"%'");
		} 
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
	
	public Student studentShow(Connection con, String studentId)throws Exception {
		String sql = "select * from t_student t1 where t1.studentId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, studentId);
		ResultSet rs=pstmt.executeQuery();
		Student student = new Student();
		if(rs.next()) {
			student.setStudentId(rs.getInt("studentId"));
			int jianliid = rs.getInt("jianliid");
			student.setEmail(rs.getString("email"));
			student.setName(rs.getString("name"));
			student.setSex(rs.getString("sex"));
			student.setStuNum(rs.getString("stuNum"));
			student.setTel(rs.getString("tel"));
			student.setPassword(rs.getString("password"));
                        student.setCity(rs.getString("city"));
		}
		return student;
	}
	
	public int studentAdd(Connection con, Student student)throws Exception {
		String sql = "insert into t_student values(null,?,?,?,?,?,?,0,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNum());
		pstmt.setString(2, student.getPassword());
		pstmt.setString(3, student.getName());
		pstmt.setString(4, student.getSex());
		pstmt.setString(5, student.getTel());
		pstmt.setString(6, student.getEmail());
                pstmt.setString(7, student.getCity());
		return pstmt.executeUpdate();
	}
	
	public int studentDelete(Connection con, String studentId)throws Exception {
		String sql = "delete from t_student where studentId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, studentId);
		return pstmt.executeUpdate();
	}
	
	public int studentUpdate(Connection con, Student student)throws Exception {
		String sql = "update t_student set stuNum=?,password=?,name=?,sex=?,tel=?,email=?,city=? where studentId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuNum());
		pstmt.setString(2, student.getPassword());
		pstmt.setString(3, student.getName());
		pstmt.setString(4, student.getSex());
		pstmt.setString(5, student.getTel());
		pstmt.setString(6, student.getEmail());
		
		pstmt.setString(7, student.getCity());
                pstmt.setInt(8, student.getStudentId());
		return pstmt.executeUpdate();
	}
	
	
}
