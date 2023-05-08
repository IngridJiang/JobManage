/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.web;

import com.lero.dao.GonggaoDao;

import com.lero.model.Gonggao;
import com.lero.model.Student;
import com.lero.util.DbUtil;
import com.lero.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class GonggaoServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	GonggaoDao gonggaoDao = new GonggaoDao();
	
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
		String s_gonggaoText = request.getParameter("s_gonggaoText");
		
		String searchType = request.getParameter("searchType");
		String action = request.getParameter("action");
		Gonggao gonggao = new Gonggao();
		if("preSave".equals(action)) {
			gonggaoPreSave(request, response);
			return;
		} else if("save".equals(action)){
			gonggaoSave(request, response);
			return;
		} else if("delete".equals(action)){
			gonggaoDelete(request, response);
			return;
		} else if("list".equals(action)) {
			if(StringUtil.isNotEmpty(s_gonggaoText)) {
				if("adminName".equals(searchType)) {
					gonggao.setAdminName(s_gonggaoText);
				} else if("contain".equals(searchType)) {
					gonggao.setContain(s_gonggaoText);
				} 
			}
			
			
			
			session.removeAttribute("gonggaoText");
			session.removeAttribute("searchType");
			
			request.setAttribute("s_gonggaoText", s_gonggaoText);
			request.setAttribute("searchType", searchType);
			
		} else if("search".equals(action)){
			if(StringUtil.isNotEmpty(s_gonggaoText)) {
				if("adminName".equals(searchType)) {
					gonggao.setAdminName(s_gonggaoText);
				} else if("contain".equals(searchType)) {
					gonggao.setContain(s_gonggaoText);
				}
				session.setAttribute("s_gonggaoText", s_gonggaoText);
				session.setAttribute("searchType", searchType);
			} else {
				session.removeAttribute("s_gonggaoText");
				session.removeAttribute("searchType");
			}
			
		} else {
			if("admin".equals((String)currentUserType)) {
				if(StringUtil.isNotEmpty(s_gonggaoText)) {
					if("adminName".equals(searchType)) {
						gonggao.setAdminName(s_gonggaoText);
					} else if("contain".equals(searchType)) {
						gonggao.setContain(s_gonggaoText);
					} 
					session.setAttribute("s_gonggaoText", s_gonggaoText);
					session.setAttribute("searchType", searchType);
				}
				
				if(StringUtil.isEmpty(s_gonggaoText)) {
					Object o1 = session.getAttribute("s_gonggaoText");
					Object o2 = session.getAttribute("searchType");
					
					if(o1!=null) {
						if("adminName".equals((String)o2)) {
							gonggao.setAdminName((String)o1);
						} else if("contain".equals((String)o2)) {
							gonggao.setContain((String)o1);
						} 
					}
					
				}
			} 
		}
		Connection con = null;
		try {
			con=dbUtil.getCon();
			if("admin".equals((String)currentUserType)) {
				List<Gonggao>gonggaoList = gonggaoDao.gonggaoList(con, gonggao);
				
				request.setAttribute("gonggaoList", gonggaoList);
				request.setAttribute("mainPage", "admin/gonggao.jsp");
				request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
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

	private void gonggaoDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			gonggaoDao.gonggaoDelete(con, id);
			request.getRequestDispatcher("gonggao?action=list").forward(request, response);
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

	private void gonggaoSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		String contain = request.getParameter("contain");
		String password = request.getParameter("password");
		
		String adminName = request.getParameter("adminName");
		
		Gonggao gonggao = new Gonggao(contain, adminName);
		if(StringUtil.isNotEmpty(id)) {
			gonggao.setId(Integer.parseInt(id));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(id)) {
				saveNum = gonggaoDao.gonggaoUpdate(con, gonggao);
			}  else {
				saveNum = gonggaoDao.gonggaoAdd(con, gonggao);
			}
			if(saveNum > 0) {
				request.getRequestDispatcher("gonggao?action=list").forward(request, response);
			} else {
				request.setAttribute("gonggao", gonggao);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "admin/gonggaoSave.jsp");
				request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
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

	private void gonggaoPreSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if (StringUtil.isNotEmpty(id)) {
				Gonggao gonggao = gonggaoDao.gonggaoShow(con, id);
				request.setAttribute("gonggao", gonggao);
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
		request.setAttribute("mainPage", "admin/gonggaoSave.jsp");
		request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
	}

  

    
}
