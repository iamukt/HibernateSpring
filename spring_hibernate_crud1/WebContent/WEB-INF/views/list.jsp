<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">${param.status}
		<c:forEach var="cust" items="${cust_list}">
${cust.name} ${cust.email} ${cust.regDate} <a
				href="<spring:url value='update/${cust.id}'/>">Update Me</a>
			<a href="<spring:url value='delete/${cust.id}'/>">UnSubscribe Me</a>
			<br />
		</c:forEach>
	</h3>
	<a href="<spring:url value='register'/>">Register New User</a>
</body>
</html>