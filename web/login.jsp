<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>图书管理系统登录界面</title>
    <style type="text/css">
        /* 清除默认样式 同时给所有元素设置样式 */
        * {
            margin: 0;
            padding: 0;
            font-family: "Open Sans Light";
            letter-spacing: .07em; /* 字母间隔大小 */
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .wrap {
            height: 100%;
            background-image: linear-gradient(to right, #30cfd0, #330867);
        }
        /* 这个是登录区域 */
        .login-wrap {
            width: 200px;
            height: 400px;
            background-color: rgba(170, 170, 255, 0.3);
            /* 居中开始 */
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            /* 居中结束 */
            border-radius: 10px;
            padding: 0 50px; /* 左右留出空余 */
        }
        /* 给最上面的Login这个标题设置样式 */
        .login-title {
            font-size: 25px;
            text-align: center;
            line-height: 100px;
            color: #fff;
            font-weight: bold;
        }
        /* 输入设置样式 */
        .login-form .login-input{
            display: block; /* input 标签是行内元素 */
            width: 100%;
            border: 0;
            border-bottom: 1px solid #ccc;
            padding: 10px 0 10px 10px;
            margin-bottom: 20px;
            outline: none; /* 输入框边框去掉 */
            background-color: transparent; /* 透明色 */
        }
        .login-form .login-input::placeholder {
            text-transform: uppercase; /* 设置placeholder内容的大小写 */
            color: #bdbdbd;
        }
        /* 给登录提交按钮设置样式 */
        .login-form .login-submit {
            width: 100%;
            line-height: 30px;
            border: 0;
            border-radius: 3px;
            margin-top: 20px;
            background-image: linear-gradient(to right, #5ee7df, #b490ca);
            font-size: 16px;
            text-align: center;
            cursor: pointer;
            color: #aa00ff;
            font-weight: bold;
        }
        /* tip 区域样式 */
        .tip {
            margin-top: 20px;
        }
        .tip a {
            padding-left: 110px;
            text-decoration: none;
            color: #7d3ebc;
        }
    </style>
</head>
<body>
<div class="wrap">
    <div class="login-wrap">
        <div class="login-title">
            登录界面
        </div>
        <div class="login-form">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <input type="text" name="username" placeholder="username" class="login-input">
                <input type="password" name="password" placeholder="password" class="login-input">
                <input type="submit" name="登录" value="Login" class="login-submit"/>
            </form>
        </div>
        <div class="tip">
            Don't have account? <a href="/registerPage.jsp">Sign up</a>
        </div>
    </div>
</div>
</body>
</html>


