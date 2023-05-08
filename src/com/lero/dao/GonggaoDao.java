/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.dao;

import com.lero.model.Gonggao;
import com.lero.model.Student;
import com.lero.util.StringUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author X
 */
public class GonggaoDao {
    
public List<Gonggao> gonggaoList(Connection con, Gonggao s_gonggao)throws Exception {
		List<Gonggao> gonggaoList = new ArrayList<Gonggao>();
		StringBuffer sb = new StringBuffer("select * from t_gonggao t1");
		if(StringUtil.isNotEmpty(s_gonggao.getContain())) {
			sb.append(" and t1.contain like '%"+s_gonggao.getContain()+"%'");
		}
                    
		
			
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Gonggao gonggao=new Gonggao();
			gonggao.setId(rs.getInt("id"));
                        gonggao.setAdminName(rs.getString("adminName"));
			gonggao.setContain(rs.getString("contain"));
			
			gonggaoList.add(gonggao);
		}
		return gonggaoList;
                
	
	}
	
	
	
	
	
	
	public int gonggaoCount(Connection con, Gonggao s_gonggao)throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from t_gonggao t1");
		if(StringUtil.isNotEmpty(s_gonggao.getContain())) {
			sb.append(" and t1.contain like '%"+s_gonggao.getContain()+"%'");
		}
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
	
	public Gonggao gonggaoShow(Connection con, String id)throws Exception {
		String sql = "select * from t_gonggao t1 where t1.id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Gonggao gonggao = new Gonggao();
		if(rs.next()) {
			gonggao.setId(rs.getInt("id"));
			
			gonggao.setContain(rs.getString("contain"));
			gonggao.setAdminName(rs.getString("adminName"));
			
		}
		return gonggao;
	}
	
	public int gonggaoAdd(Connection con, Gonggao gonggao)throws Exception {
		String sql = "insert into t_gonggao values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gonggao.getContain());
		pstmt.setString(2, gonggao.getAdminName());
		
		return pstmt.executeUpdate();
	}
	
	public int gonggaoDelete(Connection con, String id)throws Exception {
		String sql = "delete from t_gonggao where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public int gonggaoUpdate(Connection con, Gonggao gonggao)throws Exception {
		String sql = "update t_gonggao set contain=?,adminName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, gonggao.getContain());
		pstmt.setString(2, gonggao.getAdminName());
		
		return pstmt.executeUpdate();
	}
	
	
}

