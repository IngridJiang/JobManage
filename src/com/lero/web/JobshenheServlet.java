/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.web;

import com.lero.dao.JobDao;
import com.lero.dao.QiyeDao;
import com.lero.model.Job;
import com.lero.model.Qiye;
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
public class JobshenheServlet extends HttpServlet {
     private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	JobDao jobDao = new JobDao();
	
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
	Job job = new Job();
        if("preSave".equals(action)) {
			jobPreSave(request, response);
			return;
		} else if("save".equals(action)){
			jobSave(request, response);
			return;
		}
                        else if("tongguo".equals(action)){
			jobTongguo(request, response);
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
				
				
			
				request.setAttribute("mainPage", "admin/jobshenhe.jsp");
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
        
         private void jobTongguo(HttpServletRequest request,
			HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			jobDao.jobTongguo(con, uuid);
			request.getRequestDispatcher("js?action=list").forward(request, response);
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
	private void jobSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
                     String comid = request.getParameter("comid");
		String name = request.getParameter("name");
		String jiancheng = request.getParameter("jiancheng");
		String money =  request.getParameter("money");
		String des= request.getParameter("des");
		String email= request.getParameter("email");
                String uuid = request.getParameter("uuid");
                String leibie= request.getParameter("leibie");
                String city= request.getParameter("city");
		String beizhu = request.getParameter("beizhu");
                Job job=new Job(0,name,city,des,0,email,1,jiancheng,beizhu,leibie);     
                        
		if(StringUtil.isNotEmpty(uuid)) {
			job.setUuid(Integer.parseInt(uuid));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(uuid)) {
				saveNum = jobDao.jobJujue(con, job);
			}  
			if(saveNum > 0) {
				request.getRequestDispatcher("js?action=list").forward(request, response);
			} else {
				request.setAttribute("job", job);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "admin/jujuejob.jsp");
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

	private void jobPreSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		String uuid = request.getParameter("uuid");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if (StringUtil.isNotEmpty(uuid)) {
				Job job = jobDao.jobShow(con, uuid);
				request.setAttribute("job", job);
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
		request.setAttribute("mainPage", "admin/jujuejob.jsp");
		request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
	}
        

   
}
