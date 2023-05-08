/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.dao;

import com.lero.model.Qiye;
import com.lero.model.Qiyezhanghao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author X
 */
public class QiyeDao {
    public Qiye qiyeShow(Connection con, String comid)throws Exception {
		String sql = "select * from t_qiye t1 where t1.comid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, comid);
		ResultSet rs=pstmt.executeQuery();
		Qiye qiye = new Qiye();
		if(rs.next()) {
			qiye.setComid(rs.getInt("comid"));
			qiye.setZaixianNum(rs.getInt("zaixianNum"));
                        qiye.setComid(rs.getInt("comid"));
			qiye.setQuancheng(rs.getString("quancheng"));
			qiye.setEmail(rs.getString("email"));
			qiye.setJiancheng(rs.getString("jiancheng"));
                        qiye.setXindai(rs.getString("xindai"));
                        qiye.setDescrip(rs.getString("descrip"));
                        qiye.setQh(rs.getString("qh"));
                        qiye.setCity(rs.getString("city"));
                       qiye.setBeizhu(rs.getString("beizhu"));
		}
		return qiye;
	}
	
	public int qiyeAdd(Connection con, Qiye qiye)throws Exception {
		String sql = "insert into t_qiye values(null,?,?,?,?,?,1,null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qiye.getQuancheng());
		pstmt.setString(2, qiye.getJiancheng());
                pstmt.setString(3, qiye.getXindai());
                pstmt.setString(4, qiye.getDescrip());
                pstmt.setString(5, qiye.getEmail());
                 pstmt.setInt(6, qiye.getZaixianNum());
		pstmt.setString(7, qiye.getQh());
                pstmt.setString(8, qiye.getCity());
		return pstmt.executeUpdate();
	}
	
	public int qiyeDelete(Connection con, String comid)throws Exception {
		String sql = "delete from t_qiye where comid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, comid);
		return pstmt.executeUpdate();
	}
	
        public int qiyeTongguo(Connection con, String comid)throws Exception {
		String sql = "update t_qiye set shenhe=1,beizhu=null where comid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, comid);
		return pstmt.executeUpdate();
	}
	public int qiyeUpdate(Connection con, Qiye qiye)throws Exception {
		String sql = "update t_qiye set quancheng=?,jiancheng=?,xindai=?,descrip=?,email=?,zaixianNum=?,qh=?,city=? where comid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qiye.getQuancheng());
		pstmt.setString(2, qiye.getJiancheng());
                pstmt.setString(3, qiye.getXindai());
                pstmt.setString(4, qiye.getDescrip());
                pstmt.setString(5, qiye.getEmail());
                 pstmt.setInt(6, qiye.getZaixianNum());
		pstmt.setString(7, qiye.getQh());
                pstmt.setString(8, qiye.getCity());
                
                pstmt.setInt(9, qiye.getComid());
		return pstmt.executeUpdate();
	}
        public int qiyeJujue(Connection con, Qiye qiye)throws Exception {
		String sql = "update t_qiye set beizhu=? where comid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qiye.getBeizhu());
		
                
                pstmt.setInt(2, qiye.getComid());
		return pstmt.executeUpdate();
	}
         
        public int qiyeUpdateq(Connection con, Qiye qiye)throws Exception {
		String sql = "update t_qiye set quancheng=?,jiancheng=?,xindai=?,descrip=?,email=?,city=? where comid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qiye.getQuancheng());
		pstmt.setString(2, qiye.getJiancheng());
                pstmt.setString(3, qiye.getXindai());
                pstmt.setString(4, qiye.getDescrip());
                pstmt.setString(5, qiye.getEmail());
               
                pstmt.setString(6, qiye.getCity());
                
                pstmt.setInt(7, qiye.getComid());
		return pstmt.executeUpdate();
	}
        
        public int qiyeAddq(Connection con, Qiye qiye)throws Exception {
		String sql = "insert into t_qiye values(null,?,?,?,?,?,0,null,20,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, qiye.getQuancheng());
		pstmt.setString(2, qiye.getJiancheng());
                pstmt.setString(3, qiye.getXindai());
                pstmt.setString(4, qiye.getDescrip());
                pstmt.setString(5, qiye.getEmail());
                 
		pstmt.setString(6, qiye.getQh());
                pstmt.setString(7, qiye.getCity());
		return pstmt.executeUpdate();
	}
}
