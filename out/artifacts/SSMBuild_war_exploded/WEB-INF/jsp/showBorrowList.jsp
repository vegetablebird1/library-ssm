<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅情况</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row cleanfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>借阅情况</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">返回图书馆主页</a>
            </div>
        </div>

    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>借书编号</th>
                    <th>借书人</th>
                    <th>书名</th>
                    <th>借书量</th>
                </tr>
                </thead>

                <%--数据库取值--%>
                <tbody>
                <c:forEach var="borrow" items="${borrowLists}">
                    <tr>
                        <td>${borrow.borrow_id}</td>
                        <td>${borrow.username}</td>
                        <td>${borrow.bookName}</td>
                        <td>${borrow.number}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
