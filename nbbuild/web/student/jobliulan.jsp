
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="data_list">
		<div class="data_list_title">
		职位查看

		</div>
    
                
    
			
                    <div class="data_form" >
                        <h2 class="text-center">职位名称：  ${job.name }  </h2>
				<p class="text-center"> 企业简称：   ${job.jiancheng }</p>
                                <p class="text-center"> 类别：   ${job.leibie }</p>
                                <p class="text-center"> 城市：   ${job.city }</p>
				<p class="text-center"> 薪资：   ${job.money }</p>		
				<p class="text-center"> 职位描述：   ${job.des }</p>			
				<p class="text-center"> 企业邮箱：   ${job.email }</p>			
							
                                               
                                             
					<div align="center">
						
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='jobs'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		
</div>

    
    
    
   
                                
		