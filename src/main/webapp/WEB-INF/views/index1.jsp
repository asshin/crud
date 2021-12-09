<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2021/12/1
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>list222222222222</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- web路径：
    不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
    以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
            http://localhost:3306/crud
     -->
    <script type="text/javascript"
            src="static/js/jquery-1.12.4.min.js"></script>
    <link
            href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">


    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    // $(function(){
    //     //去首页
    //     to_page(1);
    // });

    $(function to_page(pn){
        $.ajax({
            url:"http://localhost:8080/crud_war/emps",
            data:"pn=1",
            type:"GET",
            success:function(result){
                console.log(result);

            }
        });
    })

</script>

</body>
</html>
