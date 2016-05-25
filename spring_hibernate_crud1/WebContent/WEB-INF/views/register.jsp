<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<form:form action="register" modelAttribute="custModel" method="post">
		<table>
			<tr>
				<td><form:label path="id">Customer ID</form:label></td>
				<td><form:input path="id" readonly="true" /></td>
				<td><form:errors cssClass="error" path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Enter Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors cssClass="error" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Enter Email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors cssClass="error" path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Enter Password</form:label></td>
				<td><form:password path="password" showPassword="true" /></td>
				<td><form:errors cssClass="error" path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="depositAmt">Reg Amount</form:label></td>
				<td><form:input path="depositAmt" /></td>
				<td><form:errors cssClass="error" path="depositAmt" /></td>
			</tr>
			<tr>
				<td><form:label path="regDate">Reg Date</form:label></td>
				<td><form:input path="regDate" /></td>
				<td><form:errors cssClass="error" path="regDate" /></td>
			</tr>
			<tr>
				<td><form:label path="role">Role</form:label></td>
				<td><form:radiobutton path="role" value="admin" label="Admin" />
				<td><form:radiobutton path="role" value="cust" label="Customer" />
				<td><form:errors cssClass="error" path="role" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register Me" /></td>
			</tr>
		</table>
	</form:form>


</body>
</html>