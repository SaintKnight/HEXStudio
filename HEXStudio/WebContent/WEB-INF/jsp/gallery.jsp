<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.hexstudio.GlobalVariableObject" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HEX Gallery</title>
</head>
<body>
	<h1>
		<%-- bla: ${currentUser} <br> --%>
		<c:choose>
			<c:when test="${empty currentUser}">
				admin login <a href="./login?url=${url}">login</a> <br>
			</c:when>
			<c:otherwise>
				logout <a href="./loginoutresult?url=${url}">logout</a> <br>
				upload <a href="./upload.jsp">upload</a> <br>
				upload multiple <a href="./uploadMultiple.jsp">upload multiple</a> <br>
			</c:otherwise>
		</c:choose>
		image: <img src="./imageController${imagename}" />
		<%-- test <a href="./login?url=${imagename}">loginaaa</a> --%>
	</h1>
</body>
</html>