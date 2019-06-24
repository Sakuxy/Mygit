<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>


<body>
	<p style="color:red">${msg}</p><hr>
	<table border=1>
		<tr>
			<td>用户名</td>	
			<td>电话</td>
			<td>地址</td>
		</tr>
		<tr>
			<td>${user.username }</td>
			<td>${user.tel }</td>
			<td>${user.address }</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath }/login">退出</a>
	<hr>
</body>
</html>
