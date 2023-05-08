/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.web;

import com.lero.dao.LuntanDao;
import com.lero.dao.QiyezhanghaoDao;
import com.lero.model.Luntan;
import com.lero.model.Qiyezhanghao;
import com.lero.util.DbUtil;
import com.lero.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author X
 */
public class LuntanServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	LuntanDao luntanDao = new LuntanDao();
	
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
		String s_luntanText = request.getParameter("s_luntanText");
		
		String searchType = request.getParameter("searchType");
		String action = request.getParameter("action");
		Luntan luntan = new Luntan();
		if("preSave".equals(action)) {
			luntanPreSave(request, response);
			return;
		} else if("save".equals(action)){
                    if("student".equals((String)currentUserType)){
			luntanSave(request, response);
			return;}
		} else if("delete".equals(action)){
			luntanDelete(request, response);
			return;
		} else if("list".equals(action)) {
			if(StringUtil.isNotEmpty(s_luntanText)) {
				if("student".equals(searchType)) {
					luntan.setStudent(s_luntanText);
				} else if("zhuti".equals(searchType)) {
					luntan.setZhuti(s_luntanText);
				} 
			}
			
			
			
			session.removeAttribute("s_luntanText");
			session.removeAttribute("searchType");
			
			request.setAttribute("s_luntanText", s_luntanText);
			request.setAttribute("searchType", searchType);
			
		}  else {
			if("admin".equals((String)currentUserType)) {
				if(StringUtil.isNotEmpty(s_luntanText)) {
					
					session.setAttribute("s_luntanText", s_luntanText);
					session.setAttribute("searchType", searchType);
				}
				
				if(StringUtil.isEmpty(s_luntanText)) {
					Object o1 = session.getAttribute("s_luntanText");
					Object o2 = session.getAttribute("searchType");
					
					
				}}
			 
		}
		Connection con = null;
		try {
			con=dbUtil.getCon();
			if("admin".equals((String)currentUserType)) {
				List<Luntan> luntanList = luntanDao.luntanList(con, luntan);
				
				request.setAttribute("luntanList", luntanList);
				request.setAttribute("mainPage", "admin/luntan.jsp");
				request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
                        }else if("student".equals((String)currentUserType)) {
				List<Luntan> luntanList = luntanDao.luntanList(con, luntan);
				
				request.setAttribute("luntanList", luntanList);
				request.setAttribute("mainPage", "student/luntan.jsp");
				request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
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
	}

	private void luntanDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			luntanDao.luntanDelete(con, id);
			request.getRequestDispatcher("luntan?action=list").forward(request, response);
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

	private void luntanSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
            String id = request.getParameter("id");
		
		
		String zhuti= request.getParameter("zhuti");
                String contain= request.getParameter("contain");
		String nimingornot= request.getParameter("nimingornot");
                String student= request.getParameter("student");
               
                
              
             int c=0;
             int d=0;
             if(StringUtil.isNotEmpty(nimingornot)){c=Integer.parseInt(nimingornot);
  
		Luntan luntan = new Luntan(student,c,zhuti,contain);
              
		if(StringUtil.isNotEmpty(id)) {
			luntan.setId(Integer.parseInt(id));
                        luntan.setZhuti(zhuti);
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(id)) {
				saveNum = luntanDao.luntanUpdate(con, luntan);
			}  else {
				saveNum = luntanDao.luntanAdd(con, luntan);
			}
			if(saveNum > 0) {
				request.getRequestDispatcher("luntan?action=list").forward(request, response);
			} else {
				request.setAttribute("luntan",luntan);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "student/luntanSave.jsp");
				request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
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
             }}

	private void luntanPreSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if (StringUtil.isNotEmpty(id)) {
				Luntan luntan = luntanDao.luntanShow(con, id);
				request.setAttribute("luntan", luntan);
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
		request.setAttribute("mainPage", "student/luntanSave.jsp");
		request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
	}
        
      
    
 
}
