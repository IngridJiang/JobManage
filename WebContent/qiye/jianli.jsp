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
		简历查看

		</div>
    
                
    
			
                    <div class="data_form" >
                        <h2 class="text-center">个人总结：  ${jianli.grzj }  </h2>
				<p class="text-center"> 性别：   ${jianli.sex }</p>
                                <p class="text-center"> 电话：   ${jianli.tel }</p>
                                <p class="text-center"> 邮箱：   ${jianli.email }</p>
				<p class="text-center"> 城市：   ${jianli.city }</p>		
				<p class="text-center"> 教育经历：   ${jianli.jyjl }</p>			
				<p class="text-center"> 项目经历：   ${jianli.xm }</p>			
				<p class="text-center"> 实习经历：   ${jianli.sx }</p>
                                <p class="text-center"> 学术经历：   ${jianli.xs }</p>
                                 <p class="text-center"> 获奖经历：   ${jianli.hj }</p> 
                                 <p class="text-center"> 作品链接：   ${jianli.zp }</p>
                                 <p class="text-center"> 兴趣爱好：   ${jianli.xq }</p>
                                             
					<div align="center">
						
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='tq'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		
</div>

    
    
    
   
                                
		