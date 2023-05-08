/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.dao;

import com.lero.model.Job;
import com.lero.model.Qiye;
import com.lero.model.Toudi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author X
 */
public class JobDao {
    
    
    public Job jobShow(Connection con, String uuid)throws Exception {
		String sql = "select * from t_job t1 where t1.uuid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, uuid);
		ResultSet rs=pstmt.executeQuery();
		Job job = new Job();
		if(rs.next()) {
			job.setUuid(rs.getInt("uuid"));
			job.setMoney(rs.getInt("money"));
                        job.setComid(rs.getInt("comid"));
                        job.setShenhe(rs.getInt("shenhe"));
			job.setName(rs.getString("name"));
			job.setEmail(rs.getString("email"));
			job.setJiancheng(rs.getString("jiancheng"));
                        job.setLeibie(rs.getString("leibie"));
                        job.setDes(rs.getString("des"));
                        
                        job.setCity(rs.getString("city"));
                       job.setBeizhu(rs.getString("beizhu"));
		}
		return job;
	}
	
	public int jobAdd(Connection con, Job job)throws Exception {
		String sql = "insert into t_job values(null,?,?,?,?,?,?,1,?,null,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
                pstmt.setInt(1, job.getComid());
		pstmt.setString(2, job.getName());
                pstmt.setString(3, job.getCity());
                pstmt.setString(4, job.getDes());
                pstmt.setInt(5, job.getMoney());
                 pstmt.setString(6, job.getEmail());
		pstmt.setString(7, job.getJiancheng());
                pstmt.setString(8, job.getLeibie());
		return pstmt.executeUpdate();
	}
	
	public int jobDelete(Connection con, String uuid)throws Exception {
		String sql = "delete from t_job where uuid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, uuid);
		return pstmt.executeUpdate();
	}
	
        public int jobTongguo(Connection con, String uuid)throws Exception {
		String sql = "update t_job set shenhe=1,beizhu=null where uuid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, uuid);
		return pstmt.executeUpdate();
	}
	public int jobUpdate(Connection con, Job job)throws Exception {
		String sql = "update t_job set comid=?,name=?,city=?,des=?,money=?,email=?,jiancheng=?,leibie=? where uuid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, job.getComid());
		pstmt.setString(2, job.getName());
                pstmt.setString(3, job.getCity());
                pstmt.setString(4, job.getDes());
                pstmt.setInt(5, job.getMoney());
                 pstmt.setString(6, job.getEmail());
		pstmt.setString(7, job.getJiancheng());
                pstmt.setString(8, job.getLeibie());
                
                
                pstmt.setInt(9, job.getUuid());
		return pstmt.executeUpdate();
	}
        public int jobJujue(Connection con, Job job)throws Exception {
		String sql = "update t_job set beizhu=? where uuid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, job.getBeizhu());
		
                
                pstmt.setInt(2, job.getUuid());
		return pstmt.executeUpdate();
	}
         
        
        
        public int jobToudi(Connection con, Toudi toudi)throws Exception {
		String sql = "insert into t_toudi values(null,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
                pstmt.setInt(1, toudi.getUuid());
		pstmt.setInt(2, toudi.getStudentId());
                pstmt.setInt(3, toudi.getJianliid());
                
		return pstmt.executeUpdate();
	}
    
}
