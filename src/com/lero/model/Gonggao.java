/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.model;

/**
 *
 * @author X
 */
public class Gonggao {
    
    
 private int id;
	private String contain;
	
	private String adminName;
	
	public Gonggao() {
	}
	
	
	public Gonggao(String contain,String adminName) {
		this.contain = contain;
		this.adminName = adminName;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContain() {
		return contain;
	}
	public void setContain(String contain) {
		this.contain = contain;
		
	}
	
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	
    
}
