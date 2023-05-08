/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.model;

/**
 *
 * @author X
 */
public class Luntan {
    
    private int id;
    private String student;
    private int nimingornot;
    
	private String zhuti;
	private String contain;
	
	
	public Luntan() {

	}
	
        public Luntan(String student,int nimingornot,String zhuti,String contain) {
		this.contain = contain;
		this.student = student;
                this.nimingornot = nimingornot;
               
                this.zhuti = zhuti;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
        
        public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}public int getNimingornot() {
		return nimingornot;
	}
	public void setNimingornot(int nimingornot) {
		this.nimingornot = nimingornot;
	}
	public String getZhuti() {
		return zhuti;
	}
	public void setZhuti(String zhuti) {
		this.zhuti = zhuti;
	}
	public String getContain() {
		return contain;
	}
	public void setContain(String contain) {
		this.contain = contain;
	}
	
    
}
