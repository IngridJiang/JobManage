/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.model;

/**
 *
 * @author X
 */
public class Jianli {
    private int jianliid;
	
        private int studentId;
	private String tel;
        private String email;
        private String sex;
        
        private String city;
        private String jyjl;  //教育经历
        private String xm;   //项目经历
        private String sx;    //实习经历
        private String xs;    //学术经历
        private String hj;    //获奖经历
        private String zp;    //作品链接
         private String grzj;   //个人总结 
          private String xq;    //兴趣爱好
	
	
	
      
	
	public Jianli() {
	}
	
	
	public Jianli(int studentId,String tel, String city,String sex,String email,String jyjl,String sx,String xm,String xs,String hj,String zp,String grzj,String xq) 
        {
		
		
		this.tel = tel;
                this.studentId = studentId;
                this.jyjl = jyjl;
                this.city = city;
                this.email = email;
                this.sx = sx;
                this.sex = sex;
                this.xm=xm;
                
		this.xs = xs;
		this.hj = hj;
                this.zp = zp;
                this.grzj = grzj;
                this.xq = xq;
		
	}
       
       
        
        
         public int getJianliid() {
		return jianliid;
	}
	public void setJianliid(int jianliid) {
		this.jianliid = jianliid;
	}
        public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
        
        public String getJyjl() {
		return jyjl;
	}
	public void setJyjl(String jyjl) {
		this.jyjl = jyjl;
	}
         public String getXq() {
		return xq;
	}
	public void setXq(String xq) {
		this.xq = xq;
	}
         public String getGrzj() {
		return grzj;
	}
	public void setGrzj(String grzj) {
		this.grzj = grzj;
	}
         public String getZp() {
		return zp;
	}
	public void setZp(String zp) {
		this.zp = zp;
	}
        public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
        public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
        
         public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
       
        public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
        public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
		
	}
        
         public String getXs() {
		return xs;
	}
	public void setXs(String xs) {
		this.xs = xs;
	}
         public String getHj() {
		return hj;
	}
	public void setHj(String hj) {
		this.hj = hj;
	}
        
        public String getSx() {
		return sx;
	}
	public void setSx(String sx) {
		this.sx = sx;
	}
        
        
        
        
       
	

    
    
    
}
