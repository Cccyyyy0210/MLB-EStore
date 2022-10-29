<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MLB-EStore会员注册页面</title>
	<%@ include file="/pages/common/head.jsp" %>
	<style type="text/css">
        h1 {
            border: white 2px solid;
            background-color: white;
            width:100px;
            text-align: center;
            margin-top: 200px;
            margin-left: auto;
            margin-right: auto;
        }

        h1 a {
            color: red;
        }


	</style>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="static/img/logo1.gif">
	<%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main" style="background: url('static/img/regist_bgi.png')">

	<h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>

</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>