<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/static/css/main.css' />" rel="stylesheet" media="screen" />

<title>Cafe con Leche - AWS Elastic Beanstalk</title>
</head>
<body>
	<div id="page">
		<div id="header">
			<img alt="Cafe con Leche" src="<c:url value='/static/image/logo.jpg' />" />
			<h1>Amazon Web Services</h1>
		</div>
		<div id="menu">
			<a href="${pageContext.request.contextPath}" >Home</a> | 
			<a href="http://topi.cafeconleche.xyz" target="_blank">Website</a> | 
			<a href="${pageContext.request.contextPath}/swagger-ui.html" >Swagger UI</a> | 
			<a href="${pageContext.request.contextPath}/v2/api-docs" >API DOCS</a>
		</div>
		<div id="content">
			<h2>Welcome</h2>
			<p>This is a simple AWS Elastic Beanstalk Java application.</p>
			<br/>
			<p>Running in port: ${puerto}</p>
		</div>
		<div id="footer">
			<p>Cafe con leche - 2017</p>
			<p>Sip it!</p>
		</div>
	</div>
</body>

</html>