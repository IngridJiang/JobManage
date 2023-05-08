/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.web;

import com.lero.dao.JobDao;
import com.lero.dao.jianliDao;
import com.lero.model.Jianli;
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
public class JianliguanliServlet extends HttpServlet {

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
	Jianli jianli = new Jianli();
        if("preSave".equals(action)) {
			jianliPreSave(request, response);
			return;
		} else if("save".equals(action)){
			jianliSave(request, response);
			return;
		} else if("delete".equals(action)){
			jianliDelete(request, response);
			return;}
                        
                        else if("list".equals(action)) {
			
			
			
			;
			session.removeAttribute("searchType");
			
			
			request.setAttribute("searchType", searchType);
			
		}  
		Connection con = null;
		try {
			con=dbUtil.getCon();
			if("admin".equals((String)currentUserType)) {
				
				
			
				request.setAttribute("mainPage", "admin/jianli.jsp");
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
		}}
        private void jianliDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String jianliid = request.getParameter("jianliid");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			jianliDao.jianliDelete(con, jianliid);
			request.getRequestDispatcher("jg?action=list").forward(request, response);
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

        
        
	private void jianliSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String s="0";
            String studentId = request.getParameter("studentId");
            if(StringUtil.isNotEmpty(studentId)){
            s=request.getParameter("studentId");
            }
		String tel = request.getParameter("tel");
		String sex= request.getParameter("sex");
		String jyjl = request.getParameter("jyjl");
		String sx= request.getParameter("sx");
		String email= request.getParameter("email");
                String jianliid = request.getParameter("jianliid");
                String xm= request.getParameter("xm");
                String city= request.getParameter("city");
		String xs= request.getParameter("xs");
                String hj= request.getParameter("hj");
                String zp= request.getParameter("zp");
                String xq= request.getParameter("xq");
                String grzj= request.getParameter("grzj");
                Jianli jianli=new Jianli(Integer.parseInt(s),tel,city,sex,email,jyjl,sx,xm,xs,hj,zp,grzj,xq);      
		if(StringUtil.isNotEmpty(jianliid)) {
			jianli.setJianliid(Integer.parseInt(jianliid));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(jianliid)) {
				saveNum = jianliDao.jianliUpdate(con, jianli);
			}  else {
				saveNum = jianliDao.jianliAdd(con, jianli);
			}
			if(saveNum > 0) {
				request.getRequestDispatcher("jg?action=list").forward(request, response);
			} else {
				request.setAttribute("jianli", jianli);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "admin/jianliSave.jsp");
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

	private void jianliPreSave(HttpServletRequest request,
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
		request.setAttribute("mainPage", "admin/jianliSave.jsp");
		request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
	}
 
   
}
