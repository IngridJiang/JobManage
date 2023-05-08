/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.model;

/**
 *
 * @author X
 */
public class Qiyezhanghao {
    
        private int qhId;
	
	private String password;
	private int mainornot ;
	private int comid;
	
        private String userName;
	
	public Qiyezhanghao() {
	}
	
	public Qiyezhanghao(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}
	
	
	public Qiyezhanghao(String userName, String password, int mainornot,
			int comid) {
		
		this.userName = userName;
		this.password = password;
		this.mainornot = mainornot;
		this.comid = comid;
		
	}

	public int getQhId() {
		return qhId;
	}
	public void setQhId(int qhId) {
		this.qhId = qhId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMainornot() {
		return mainornot;
	}

	public void setMainornot(int mainornot) {
		this.mainornot = mainornot;
	}
public int getComid() {
		return comid;
	}

	public void setComid(int comid) {
		this.comid = comid;
	}
	
	
	
	
	
    
}
