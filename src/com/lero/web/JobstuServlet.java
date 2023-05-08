/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lero.web;

import com.lero.dao.JobDao;
import com.lero.model.Job;
import com.lero.model.Toudi;
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
public class JobstuServlet extends HttpServlet {

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
        if("liulan".equals(action)) {
			jobPreSave(request, response);
			return;
		} else if("toudi".equals(action)){
			toudiSave(request, response);
			return;
		} else if("delete".equals(action)){
			jobDelete(request, response);
			return;}
                        
                        else if("list".equals(action)) {
			
			
			
			;
			session.removeAttribute("searchType");
			
			
			request.setAttribute("searchType", searchType);
			
		}  
		Connection con = null;
		try {
			con=dbUtil.getCon();
				request.setAttribute("mainPage", "student/job.jsp");
				request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
                        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}}
        private void jobDelete(HttpServletRequest request,
			HttpServletResponse response) {
		String uuid = request.getParameter("uuid");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			jobDao.jobDelete(con, uuid);
			request.getRequestDispatcher("jq?action=list").forward(request, response);
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

        
        
	private void toudiSave(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		
                String uuid = request.getParameter("uuid");
                String studentId= request.getParameter("studentId");
                String jianliid= request.getParameter("jianliid");
		
                Toudi toudi=new Toudi(Integer.parseInt(uuid),Integer.parseInt(studentId),Integer.parseInt(jianliid));      
                        
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			
				saveNum = jobDao.jobToudi(con, toudi);
			
			if(saveNum > 0) {
				request.getRequestDispatcher("jobs?action=list").forward(request, response);
			} else {
				request.setAttribute("toudi", toudi);
				request.setAttribute("error", "����ʧ��");
				request.setAttribute("mainPage", "student/job.jsp");
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
		request.setAttribute("mainPage", "student/jobliulan.jsp");
		request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
	}

}
