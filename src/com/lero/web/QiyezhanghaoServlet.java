
package com.lero.web;

import com.lero.dao.QiyezhanghaoDao;

import com.lero.model.Qiyezhanghao;

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
public class QiyezhanghaoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	QiyezhanghaoDao qiyezhanghaoDao = new QiyezhanghaoDao();
	
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
		String s_qiyezhanghaoText = request.getParameter("s_qiyezhanghaoText");
		
		String searchType = request.getParameter("searchType");
		String action = request.getParameter("action");
		Qiyezhanghao qiyezhanghao = new Qiyezhanghao();
		if("preSave".equals(action)) {
			qiyezhanghaoPreSave(request, response);
			return;
		} else if("save".equals(action)){
			qiyezhanghaoSave(request, response);
			return;
		} else if("delete".equals(action)){
			qiyezhanghaoDelete(request, response);
			return;
		} else if("list".equals(action)) {
			if(StringUtil.isNotEmpty(s_qiyezhanghaoText)) {
				if("userName".equals(searchType)) {
					qiyezhanghao.setUserName(s_qiyezhanghaoText);
				} else if("comid".equals(searchType)) {
					qiyezhanghao.setComid(Integer.parseInt(s_qiyezhanghaoText));
				} 
			}
			
			
			
			session.removeAttribute("s_qiyezhanghaoText");
			session.removeAttribute("searchType");
			
			request.setAttribute("s_qiyezhanghaoText", s_qiyezhanghaoText);
			request.setAttribute("searchType", searchType);
			
		} else if("search".equals(action)){
			QS(request, response);
			return;
			
		} else {
			if("admin".equals((String)currentUserType)) {
				if(StringUtil.isNotEmpty(s_qiyezhanghaoText)) {
					if("userName".equals(searchType)) {
						qiyezhanghao.setUserName(s_qiyezhanghaoText);
					} else if("comid".equals(searchType)) {
						qiyezhanghao.setComid(Integer.parseInt(s_qiyezhanghaoText));
					} 
					session.setAttribute("s_qiyezhanghaoText", s_qiyezhanghaoText);
					session.setAttribute("searchType", searchType);
				}
				
				if(StringUtil.isEmpty(s_qiyezhanghaoText)) {
					Object o1 = session.getAttribute("s_qiyezhanghaoText");
					Object o2 = session.getAttribute("searchType");
					
					if(o1!=null) {
						if("userName".equals((String)o2)) {
							qiyezhanghao.setUserName((String)o1);
						} else if("comid".equals((String)o2)) {
							qiyezhanghao.setComid(Integer.parseInt((String)o1));
						} 
					}
					
				}}
			 
		}
		Connection con = null;
		try {
			con=dbUtil.getCon();
			if("admin".equals((String)currentUserType)) {
				List<Qiyezhanghao> qiyezhanghaoList = qiyezhanghaoDao.qiyezhanghaoList(con, qiyezhanghao);
				
				request.setAttribute("qiyezhanghaoList", qiyezhanghaoList);
				request.setAttribute("mainPage", "admin/qiyeguanli.jsp");
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

	private void qiyezhanghaoSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String qhId = request.getParameter("qhId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String comid =  request.getParameter("comid");
		String mainornot= request.getParameter("mainornot");
		
		Qiyezhanghao qiyezhanghao = new Qiyezhanghao(userName, password, Integer.parseInt(mainornot), Integer.parseInt(comid));
		if(StringUtil.isNotEmpty(qhId)) {
			qiyezhanghao.setQhId(Integer.parseInt(qhId));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(qhId)) {
				saveNum = qiyezhanghaoDao.qiyezhanghaoUpdate(con, qiyezhanghao);
			}  else {
				saveNum = qiyezhanghaoDao.qiyezhanghaoAdd(con, qiyezhanghao);
			}
			if(saveNum > 0) {
				request.getRequestDispatcher("qiyezhanghao?action=list").forward(request, response);
			} else {
				request.setAttribute("qiyezhanghao",qiyezhanghao);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "admin/qiyezhanghaoSave.jsp");
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

	private void qiyezhanghaoPreSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String qhId = request.getParameter("qhId");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if (StringUtil.isNotEmpty(qhId)) {
				Qiyezhanghao qiyezhanghao = qiyezhanghaoDao.qiyezhanghaoShow(con, qhId);
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
		request.setAttribute("mainPage", "admin/qiyezhanghaoSave.jsp");
		request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
	}
        
        private void QS(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object currentUserType = session.getAttribute("currentUserType");
		if("admin".equals((String)currentUserType)) {
			String tel =request.getParameter("tel");
                        request.setAttribute("tel", tel);
                    request.setAttribute("mainPage", "admin/sousuo.jsp");
			request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
		} 
	}
}