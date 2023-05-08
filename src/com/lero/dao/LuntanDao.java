/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.dao;

import com.lero.model.Gonggao;
import com.lero.model.Luntan;
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
public class LuntanDao {
    
    public List<Luntan> luntanList(Connection con, Luntan s_luntan)throws Exception {
		List<Luntan> luntanList = new ArrayList<Luntan>();
		StringBuffer sb = new StringBuffer("select * from t_luntan t1");
		if(StringUtil.isNotEmpty(s_luntan.getContain())) {
			sb.append(" and t1.contain like '%"+s_luntan.getContain()+"%'");
		}
                    
		
			
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Luntan luntan=new Luntan();
			luntan.setId(rs.getInt("id"));
                        luntan.setStudent(rs.getString("student"));
                        luntan.setNimingornot(rs.getInt("nimingornot"));
                      
                        luntan.setZhuti(rs.getString("zhuti"));
			luntan.setContain(rs.getString("contain"));
			
			luntanList.add(luntan);
		}
		return luntanList;
                
	
	}
	
	
	
	
	
	
	public int luntanCount(Connection con, Luntan s_luntan)throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from t_luntan t1");
		if(StringUtil.isNotEmpty(s_luntan.getContain())) {
			sb.append(" and t1.contain like '%"+s_luntan.getContain()+"%'");
		}
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
	
	public Luntan luntanShow(Connection con, String id)throws Exception {
		String sql = "select * from t_luntan t1 where t1.id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Luntan luntan = new Luntan();
		if(rs.next()) {
			luntan.setId(rs.getInt("id"));
                        luntan.setStudent(rs.getString("student"));
                        luntan.setNimingornot(rs.getInt("nimingornot"));
                       
                        luntan.setZhuti(rs.getString("zhuti"));
			luntan.setContain(rs.getString("contain"));
			
		}
		return luntan;
	}
	
	public int luntanAdd(Connection con, Luntan luntan)throws Exception {
		String sql = "insert into t_luntan values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, luntan.getStudent());
		pstmt.setInt(2, luntan.getNimingornot());
              
                pstmt.setString(3, luntan.getZhuti());
		pstmt.setString(4, luntan.getContain());
		
		return pstmt.executeUpdate();
	}
	
	public int luntanDelete(Connection con, String id)throws Exception {
		String sql = "delete from t_luntan where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public int luntanUpdate(Connection con, Luntan luntan)throws Exception {
		String sql = "update t_luntan set contain=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, luntan.getContain());
		pstmt.setInt(2, luntan.getId());
		
		return pstmt.executeUpdate();
	}
    
}
