/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.model;

import java.sql.Blob;

/**
 *
 * @author X
 */
public class Qiye {
    
    
     private int comid;
	
	private String quancheng;
        private String jiancheng;
        private String xindai;
        private String descrip;
        private String email;
        private String beizhu;
        private String qh;
        private String city;
	private int shenhe ;
	private int zaixianNum;
	
      
	
	public Qiye() {
	}
	
	
	public Qiye(String quancheng, String jiancheng,String xindai, String descrip,String city,String email,String beizhu,String qh,int zaixianNum,
			int shenhe) {
		
		this.quancheng = quancheng;
		this.jiancheng = jiancheng;
                this.xindai = xindai;
                this.descrip = descrip;
                this.city = city;
                this.email = email;
                this.beizhu = beizhu;
                this.qh = qh;
                
                this.zaixianNum = zaixianNum;
		this.shenhe = shenhe;
		this.comid = comid;
		
	}
       
        public int getZaixianNum() {
		return zaixianNum;
	}
	public void setZaixianNum(int zaixianNum) {
		this.zaixianNum = zaixianNum;
	}
        
        
        
        
        public String getQh() {
		return qh;
	}
	public void setQh(String qh) {
		this.qh = qh;
	}
        
        
        
        
        public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
        
        
        
        
        public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
        public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getQuancheng() {
		return quancheng;
	}
	public void setQuancheng(String quancheng) {
		this.quancheng = quancheng;
		
	}
	
	public String getJiancheng() {
		return jiancheng;
	}
	public void setJiancheng(String jiancheng) {
		this.jiancheng = jiancheng;
	}
        	public String getXindai() {
		return xindai;
	}
	public void setXindai(String xindai) {
		this.xindai = xindai;
	}
	public int getShenhe() {
		return shenhe;
	}

	public void setShenhe(int shenhe) {
		this.shenhe = shenhe;
	}

	
	
}
