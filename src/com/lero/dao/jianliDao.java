/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.dao;

import com.lero.model.Jianli;

import com.lero.model.Qiye;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author X
 */
public class jianliDao {
    
     public Jianli jianliShow(Connection con, String jianliid)throws Exception {
		String sql = "select * from t_jianli t1 where t1.jianliid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, jianliid);
		ResultSet rs=pstmt.executeQuery();
		Jianli jianli = new Jianli();
		if(rs.next()) {
			jianli.setJianliid(rs.getInt("jianliid"));
			
                        jianli.setStudentId(rs.getInt("studentId"));
                        
			jianli.setTel(rs.getString("tel"));
			jianli.setEmail(rs.getString("email"));
			jianli.setSex(rs.getString("sex"));
                        jianli.setJyjl(rs.getString("jyjl"));
                        jianli.setXm(rs.getString("xm"));
                        
                        jianli.setCity(rs.getString("city"));
                       jianli.setSx(rs.getString("sx"));
                       jianli.setXs(rs.getString("xs"));
                       jianli.setHj(rs.getString("hj"));
                       jianli.setZp(rs.getString("zp"));
                       jianli.setXq(rs.getString("xq"));
                       jianli.setGrzj(rs.getString("grzj"));
		}
		return jianli;
	}
	
	public int jianliAdd(Connection con, Jianli jianli)throws Exception {
		String sql = "insert into t_jianli values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
                pstmt.setInt(1, jianli.getStudentId());
		pstmt.setString(2, jianli.getTel());
                pstmt.setString(3, jianli.getEmail());
                pstmt.setString(4, jianli.getSex());
                pstmt.setString(5, jianli.getCity());
                 pstmt.setString(6, jianli.getJyjl());
		pstmt.setString(7, jianli.getXm());
                pstmt.setString(8, jianli.getSx());
                pstmt.setString(9, jianli.getXs());
                pstmt.setString(10, jianli.getHj());
                pstmt.setString(11, jianli.getZp());
                pstmt.setString(12, jianli.getXq());
                pstmt.setString(13, jianli.getGrzj());
		return pstmt.executeUpdate();
	}
	
	public int jianliDelete(Connection con, String jianliid)throws Exception {
		String sql = "delete from t_jianli where jianliid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, jianliid);
		return pstmt.executeUpdate();
	}
	
      
	public int jianliUpdate(Connection con, Jianli jianli)throws Exception {
		String sql = "update t_jianli set studentId=?,tel=?,email=?,sex=?,city=?,jyjl=?,xm=?,sx=?,xs=?,hj=?,zp=?,xq=?,grzj=? where jianliid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		 pstmt.setInt(1, jianli.getStudentId());
		pstmt.setString(2, jianli.getTel());
                pstmt.setString(3, jianli.getEmail());
                pstmt.setString(4, jianli.getSex());
                pstmt.setString(5, jianli.getCity());
                 pstmt.setString(6, jianli.getJyjl());
		pstmt.setString(7, jianli.getXm());
                pstmt.setString(8, jianli.getSx());
                pstmt.setString(9, jianli.getXs());
                pstmt.setString(10, jianli.getHj());
                pstmt.setString(11, jianli.getZp());
                pstmt.setString(12, jianli.getXq());
                pstmt.setString(13, jianli.getGrzj());
                
                
                pstmt.setInt(14, jianli.getJianliid());
		return pstmt.executeUpdate();
	}
     
         
       
    
}
