/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.web;

import com.lero.dao.QiyezhanghaoDao;
import com.lero.model.Qiyezhanghao;
import com.lero.util.DbUtil;
import com.lero.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ZizhanghaoServlet extends HttpServlet {

 private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	QiyezhanghaoDao qiyezhanghaoDao = new QiyezhanghaoDao();
    Qiyezhanghao qiyezhanghao;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Object currentUserType = session.getAttribute("currentUserType");
		
		
		;
		String action = request.getParameter("action");
		Qiyezhanghao qiyezhanghao = new Qiyezhanghao();
		if("l".equals(action)) {
			
		} else if("delete".equals(action)){
			qiyeDelete(request, response);
			return;
		}  else if("add".equals(action)){
			qiyeAdd(request, response);
			return;
		} 
		Connection con = null;
		try {
			con=dbUtil.getCon();
			
				
				
				
				request.setAttribute("mainPage", "qiye/zizhanghao.jsp");
				request.getRequestDispatcher("mainQiye.jsp").forward(request, response);
                        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

private void qiyeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			qiyezhanghaoDao.qiyezhanghaoZi(con, id);
			request.getRequestDispatcher("zi?action=l").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


private void qiyeAdd(HttpServletRequest request,
			HttpServletResponse response) {
		
		String userName = request.getParameter("tel");
		int a=0;
                String comid = request.getParameter("comid");
                if(StringUtil.isNotEmpty(comid)){
		a=Integer.parseInt(comid);}
                if(StringUtil.isNotEmpty(userName)){
		qiyezhanghao = new Qiyezhanghao(userName, "1", 1, a);}
		
		
		
    
    
		Connection con = null;
		try {
			con = dbUtil.getCon();
                        if(StringUtil.isNotEmpty(comid)) {
			qiyezhanghaoDao.qiyezhanghaoA(con, qiyezhanghao);}
			request.getRequestDispatcher("zi?action=l").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



}

