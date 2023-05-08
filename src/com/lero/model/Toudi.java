/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.model;

/**
 *
 * @author X
 */
public class Toudi {
     private int uuid;
	
        private int tdid;
	
        private int studentId;
        
        
	private int jianliid ;
	
	
      
	
	public Toudi() {
	}
	
	
	public Toudi(int uuid,int studentId,int jianliid) 
        {
		
		
		this.uuid = uuid;
                this.studentId = studentId;
                this.jianliid = jianliid;
                
		
		
	}
       
        public int getTdid() {
		return tdid;
	}
	public void setTdid(int tdid) {
		this.tdid = tdid;
	}
        
        
         public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
        public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
        public int getJianliid() {
		return jianliid;
	}
	public void setJianliid(int jianliid) {
		this.jianliid = jianliid;
	}  
       
        
        
    
}
