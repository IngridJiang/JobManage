/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.model;

/**
 *
 * @author X
 */
public class Job {
    
    
    private int uuid;
	
        private int comid;
	private String name;
        private String city;
        private String des;
        private int money;
        private String email;
        private String jiancheng;
        private String beizhu;
        private String leibie;
        
	private int shenhe ;
	
	
      
	
	public Job() {
	}
	
	
	public Job(int comid,String name, String city,String des,int money,String email,int shenhe,String jiancheng,String beizhu,String leibie) 
        {
		
		
		this.jiancheng = jiancheng;
                this.comid = comid;
                this.name = name;
                this.city = city;
                this.email = email;
                this.beizhu = beizhu;
                this.des = des;
                this.leibie=leibie;
                this.money = money;
		this.shenhe = shenhe;
		
		
	}
       
       
        
        
         public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
        public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
        
        public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
        public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
        public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
         public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
         public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
        public int getShenhe() {
		return shenhe;
	}

	public void setShenhe(int shenhe) {
		this.shenhe = shenhe;
	}
        public String getJiancheng() {
		return jiancheng;
	}
	public void setJiancheng(String jiancheng) {
		this.jiancheng = jiancheng;
	}
        public String getLeibie() {
		return leibie;
	}
	public void setLeibie(String leibie) {
		this.leibie = leibie;
		
	}
        
        
        
        
        public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
        
        
        
        
       
	

    
}
