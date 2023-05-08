/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.dao;

import com.lero.model.Qiyezhanghao;

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
public class QiyezhanghaoDao {
    
    
    public List<Qiyezhanghao> qiyezhanghaoList(Connection con, Qiyezhanghao s_qiyezhanghao)throws Exception {
		List<Qiyezhanghao> qiyezhanghaoList = new ArrayList<Qiyezhanghao>();
		StringBuffer sb = new StringBuffer("select * from t_qiyezhanghao t1");
                
		if(StringUtil.isNotEmpty(s_qiyezhanghao.getUserName())) {
			sb.append(" and t1.userName like '%"+s_qiyezhanghao.getUserName()+"%'");
		}  
			
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Qiyezhanghao qiyezhanghao=new Qiyezhanghao();
			qiyezhanghao.setQhId(rs.getInt("qhId"));
                        qiyezhanghao.setMainornot(rs.getInt("mainornot"));
                        qiyezhanghao.setComid(rs.getInt("comid"));
			qiyezhanghao.setUserName(rs.getString("userName"));
			qiyezhanghao.setPassword(rs.getString("password"));
			qiyezhanghaoList.add(qiyezhanghao);
		}
		return qiyezhanghaoList;
                
	
	}
	
	
	
	
	public int qiyezhanghaoCount(Connection con, Qiyezhanghao s_qiyezhanghao)throws Exception {
		StringBuffer sb = new StringBuffer("select count(*) as total from t_qiyezhanghao t1");
		if(StringUtil.isNotEmpty(s_qiyezhanghao.getUserName())) {
			sb.append(" and t1.userName like '%"+s_qiyezhanghao.getUserName()+"%'");
		} 
		
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
	
	public Qiyezhanghao qiyezhanghaoShow(Connection con, String qhId)throws Exception {
		String sql = "select * from t_qiyezhanghao t1 where t1.qhId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qhId);
		ResultSet rs=pstmt.executeQuery();
		Qiyezhanghao qiyezhanghao = new Qiyezhanghao();
		if(rs.next()) {
			qiyezhanghao.setQhId(rs.getInt("qhId"));
			qiyezhanghao.setMainornot(rs.getInt("mainornot"));
                        qiyezhanghao.setComid(rs.getInt("comid"));
			qiyezhanghao.setUserName(rs.getString("userName"));
			
			qiyezhanghao.setPassword(rs.getString("password"));
                       
		}
		return qiyezhanghao;
	}
	
	public int qiyezhanghaoAdd(Connection con, Qiyezhanghao qiyezhanghao)throws Exception {
		String sql = "insert into t_qiyezhanghao values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qiyezhanghao.getUserName());
		pstmt.setString(2, qiyezhanghao.getPassword());
                pstmt.setInt(3, qiyezhanghao.getMainornot());
                 pstmt.setInt(4, qiyezhanghao.getComid());
		
		return pstmt.executeUpdate();
	}
	
	public int qiyezhanghaoDelete(Connection con, String qhId)throws Exception {
		String sql = "delete from t_qiyezhanghao where qhId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qhId);
		return pstmt.executeUpdate();
	}
	
        public int qiyezhanghaoZi(Connection con, String id)throws Exception {
		String sql = "update t_qiyezhanghao set comid=0 where qhId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
        
          public int qiyezhanghaoA(Connection con,Qiyezhanghao qiyezhanghao)throws Exception {
		String sql = "update t_qiyezhanghao set comid=? where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, qiyezhanghao.getComid());
                pstmt.setString(2, qiyezhanghao.getUserName());
		return pstmt.executeUpdate();
	}
	public int qiyezhanghaoUpdate(Connection con, Qiyezhanghao qiyezhanghao)throws Exception {
		String sql = "update t_qiyezhanghao set userName=?,password=?,mainornot=?,comid=? where qhId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qiyezhanghao.getUserName());
		pstmt.setString(2, qiyezhanghao.getPassword());
		pstmt.setInt(3, qiyezhanghao.getMainornot());
		pstmt.setInt(4, qiyezhanghao.getComid());
                pstmt.setInt(5, qiyezhanghao.getQhId());
		return pstmt.executeUpdate();
	}
	public int qiyezhanghaoMain(Connection con, Qiyezhanghao qiyezhanghao)throws Exception {
		String sql = "update t_qiyezhanghao set mainornot=1,comid=? where userName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		
		pstmt.setInt(1, qiyezhanghao.getComid());
                pstmt.setString(2, qiyezhanghao.getUserName());
		return pstmt.executeUpdate();
	}
}
