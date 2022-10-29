<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo1.gif">
    <span class="wel_word">订单管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>详情</td>
            <td>发货</td>

        </tr>
        <tr>
            <td>2022.10.29</td>
            <td>359.00</td>
            <td><a href="#">查看详情</a></td>
            <td><a href="#">点击发货</a></td>
        </tr>

        <tr>
            <td>2022.10.31</td>
            <td>299.00</td>
            <td><a href="#">查看详情</a></td>
            <td>已发货</td>
        </tr>

        <tr>
            <td>2022.11.21</td>
            <td>429.00</td>
            <td><a href="#">查看详情</a></td>
            <td>等待收货</td>
        </tr>
    </table>
</div>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>