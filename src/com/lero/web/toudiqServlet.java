/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.web;

import com.lero.dao.JobDao;
import com.lero.dao.jianliDao;
import com.lero.model.Jianli;
import com.lero.model.Job;
import com.lero.util.DbUtil;
import com.lero.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author X
 */
public class toudiqServlet extends HttpServlet {

     private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	jianliDao jianliDao = new jianliDao();
	
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
		
		
		String searchType = request.getParameter("searchType");
		String action = request.getParameter("action");
	if("preSave".equals(action)) {
			PreSave(request, response);
			return;
		} 
       else if("list".equals(action)) {
			
			
			
			;
			session.removeAttribute("searchType");
			
			
				
			request.setAttribute("searchType", searchType);
			
		}  
		Connection con = null;
		try {
			con=dbUtil.getCon();
				request.setAttribute("mainPage", "qiye/toudi.jsp");
				request.getRequestDispatcher("mainQiye.jsp").forward(request, response);
                        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}}
    private void PreSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String jianliid = request.getParameter("jianliid");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if (StringUtil.isNotEmpty(jianliid)) {
				Jianli jianli = jianliDao.jianliShow(con, jianliid);
				request.setAttribute("jianli", jianli);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("mainPage", "qiye/jianli.jsp");
		request.getRequestDispatcher("mainQiye.jsp").forward(request, response);
	}
   
}
