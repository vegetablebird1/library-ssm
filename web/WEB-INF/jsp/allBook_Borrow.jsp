<%@ page import="com.library.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部书籍</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<%User user = (User) session.getAttribute("user");
    String username = user.getName();
%>

<div class="container">
    <div class="row cleanfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍---------------显示所有书籍</small>
                </h1>
                <h1><small>当前用户:${sessionScope.user.name}</small></h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/borrow/allBook">显示书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/borrow/showBorrow">查看借阅情况</a>
            </div>
            <div class="col-md-4 column"></div>
            <div class="col-md-8 column">
                <form action="/borrow/queryBook" method="post" style="float: right" class="form-inline">
                    <span style="color: red;font-weight: bold">${error}</span>
                    <input type="text" name="bookName" class="form-control" placeholder="请输入要查询的书籍名称">
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
            </div>
        </div>

    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>

                <%--数据库取值--%>
                <tbody>
                <c:forEach var="book" items="${bookList_Borrow}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/borrow/borrowBook?username=<%=username%>&bookName=${book.bookName}&num=${book.bookCounts}">借书</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
