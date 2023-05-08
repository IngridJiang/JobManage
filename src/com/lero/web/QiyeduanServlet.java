package com.lero.web;


import com.lero.dao.QiyeDao;
import com.lero.dao.QiyezhanghaoDao;
import com.lero.model.Qiye;
import com.lero.model.Qiyezhanghao;
import com.lero.util.DbUtil;
import com.lero.util.StringUtil;

import java.io.IOException;

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
public class QiyeduanServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	QiyeDao qiyeDao = new QiyeDao();
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
		
		
		String searchType = request.getParameter("searchType");
		String action = request.getParameter("action");
	Qiye qiye = new Qiye();
        Qiyezhanghao qiyezhanghao = new Qiyezhanghao();
        if("preSave".equals(action)) {
			qiyePreSave(request, response);
			return;
		} else if("save".equals(action)){
			qiyeSave(request, response);
			return;
		} else if("tianjia".equals(action)){
			qiyeTianjia(request, response);
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
		}}
      

        
        
	private void qiyeSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String comid = request.getParameter("comid");
		String quancheng = request.getParameter("quancheng");
		String jiancheng = request.getParameter("jiancheng");
		String xindai =  request.getParameter("xindai");
		String descrip= request.getParameter("descrip");
		String email= request.getParameter("email");
                
                String qht= request.getParameter("qht");
                String city= request.getParameter("city");
		Qiye qiye = new Qiye(quancheng,jiancheng,xindai,descrip,city,email,"",qht,20,1);
                        
                        
		if(StringUtil.isNotEmpty(comid)) {
			qiye.setComid(Integer.parseInt(comid));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(comid)) {
				saveNum = qiyeDao.qiyeUpdateq(con, qiye);
			}  else {
				saveNum = qiyeDao.qiyeAddq(con, qiye);
			}
			if(saveNum > 0) {
				request.getRequestDispatcher("qiyeduan?action=list").forward(request, response);
			} else {
				request.setAttribute("qiye", qiye);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "qiye/qiyeSave.jsp");
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

	private void qiyePreSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String comid = request.getParameter("comid");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if (StringUtil.isNotEmpty(comid)) {
				Qiye qiye = qiyeDao.qiyeShow(con, comid);
				request.setAttribute("qiye", qiye);
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
		request.setAttribute("mainPage", "qiye/qiyeSave.jsp");
		request.getRequestDispatcher("mainQiye.jsp").forward(request, response);
	}
        private void qiyeTianjia(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
		String quancheng = request.getParameter("quancheng");
		String jiancheng = request.getParameter("jiancheng");
		String xindai =  request.getParameter("xindai");
		String descrip= request.getParameter("descrip");
		String email= request.getParameter("email");
                String comid=request.getParameter("comid");
                String qht= request.getParameter("qht");
                String city= request.getParameter("city");
		Qiye qiye = new Qiye(quancheng,jiancheng,xindai,descrip,city,email,"",qht,20,1);
                       
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			
				saveNum = qiyeDao.qiyeAddq(con, qiye);
			        
			if(saveNum > 0) {
				request.getRequestDispatcher("qiyeduan?action=list").forward(request, response);
			} else {
				request.setAttribute("qiye", qiye);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "qiye/qiyeSave.jsp");
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
        
}
