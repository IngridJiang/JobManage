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


public class MainornotServlet extends HttpServlet {

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
		if("preSave".equals(action)) {
			qiyezhanghaoPreSavet(request, response);
			return;
		} else if("save".equals(action)){
			qiyezhanghaoSavet(request, response);
			return;
		}  else if("zizhanghao".equals(action)){
			qiyezhanghaoZi(request, response);
			return;
		} else if("delete".equals(action)){
			qiyezhanghaoDelete(request, response);
			return;
		}else {
			
			 
		}
		Connection con = null;
		try {
			con=dbUtil.getCon();
			
				
				
				
				request.setAttribute("mainPage", "qiye/qiye.jsp");
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

	private void qiyezhanghaoDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String qhId = request.getParameter("qhId");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			qiyezhanghaoDao.qiyezhanghaoDelete(con, qhId);
			request.getRequestDispatcher("qiyezhanghao?action=list").forward(request, response);
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

        private void qiyezhanghaoZi(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();					
		try {
				request.setAttribute("error", "����ʧ��");
				 request.setAttribute("mainPage", "qiye/zizhanghao.jsp");
			request.getRequestDispatcher("mainQiye.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
                
		
	}
	private void qiyezhanghaoSavet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String comid="0";
		comid = request.getParameter("comid");
                if(StringUtil.isNotEmpty(comid)){
		qiyezhanghao = new Qiyezhanghao(userName, "", 1, Integer.parseInt(comid));}
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(comid)) {
				saveNum = qiyezhanghaoDao.qiyezhanghaoMain(con, qiyezhanghao);
			}  else {
				saveNum = qiyezhanghaoDao.qiyezhanghaoMain(con, qiyezhanghao);
			}
			if(saveNum > 0) {
				request.getRequestDispatcher("qiyeduan?action=list").forward(request, response);
			} else {
				request.setAttribute("qiyezhanghao",qiyezhanghao);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "qiye/mainSave.jsp");
				request.getRequestDispatcher("mainQiye.jsp").forward(request, response);
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

	private void qiyezhanghaoPreSavet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String qh = request.getParameter("qh");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if (StringUtil.isNotEmpty(qh)) {
				Qiyezhanghao qiyezhanghao = qiyezhanghaoDao.qiyezhanghaoShow(con, qh);
				request.setAttribute("qiyezhanghao", qiyezhanghao);
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
		request.setAttribute("mainPage", "qiye/mainSave.jsp");
		request.getRequestDispatcher("mainQiye.jsp").forward(request, response);
	}
}