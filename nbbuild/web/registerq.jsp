<%-- 
    Document   : registerq
    Created on : 2020-10-29, 14:05:55
    Author     : X
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <title>企业用户注册</title>
    <style type="text/css">
	  body {
        padding-top: 200px;
        padding-bottom: 40px;
        background-image: url('images/timg.jpg');
        background-position: center;
		background-repeat: no-repeat;
		background-attachment: fixed;
      }
      
      .radio {
      	padding-top: 10px;
       	padding-bottom:10px;
      }
      
      .form-signin-heading{
      	text-align: center;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 0px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
</style>

</head>
<body>
<div class="container">
      <form name="rs" class="form-signin" action="rqs.jsp" method="post" onsubmit="return checkForm()">
        <h2 class="form-signin-heading"><font color="gray">注册企业用户</font></h2>
        <input id="stuNum" name="userName" type="text" class="input-block-level" placeholder="手机号码...">
        <input id="password" name="password" type="password" class="input-block-level" placeholder="密码..." >
         
		<br>
        <button class="btn btn-large btn-primary" type="submit">注册</button>
     
      <p align="center"><a href="login.jsp" >返回</a>


		
      </form>
        
</div>
</body>
</html>
