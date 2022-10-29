<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MLB商品管理</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">

        $(function () {


            $("a.deleteClass").click(function () {
                return confirm("确认删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");

            });
        });

    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo1.gif">
    <span class="wel_word">MLB管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>商品名称</td>
            <td>价格</td>
            <td>商品简介</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="mlb">
            <tr>
                <td>${mlb.name}</td>
                <td>${mlb.price}</td>
                <td>${mlb.description}</td>
                <td>${mlb.sales}</td>
                <td>${mlb.stock}</td>
                <td>
                    <a href="manager/mlbServlet?action=getmlb&id=${mlb.id}&method=update&pageNo=${requestScope.page.pageNo}">修改</a>
                </td>
                <td><a class="deleteClass"
                       href="manager/mlbServlet?action=delete&id=${mlb.id}&pageNo=${requestScope.page.pageNo}">删除</a>
                </td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="mlb_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加商品</a></td>
        </tr>
    </table>
    <%@include file="/pages/common/page_nav.jsp" %>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>