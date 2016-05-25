<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${requestScope.status}
	<form:form method="post" modelAttribute="contact">
		<form:label path="email">Enter Email</form:label>
		<form:input path="email" />
		<br />
		<form:label path="password">Enter Password</form:label>
		<form:password path="password" />
		<br />
		<input type="submit" value="Login"/>
	</form:form>
</body>
</html>