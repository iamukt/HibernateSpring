
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="book" class="beans.BookBean" scope="session" />
<body>
	<form>
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter Book Title</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Enter Publish Date</td>
				<td><input type="text" name="pubDate" /></td>
			</tr>
			<tr>
				<td>Enter Book Author</td>
				<td><input type="text" name="author" /></td>
			</tr>
			<tr>
				<td>Enter Price</td>
				<td><input type="text" name="bookPrice" /></td>
			</tr>
			<tr>
				<td>Enter Book Quantity</td>
				<td><input type="text" name="quantity" /></td>
			</tr>

			<tr>
				<td><input name="btn" type="submit" value="Add Book" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${param.btn eq 'Add Book'}">
		<jsp:setProperty property="*" name="book" />
	${sessionScope.book.addedBook}
	</c:if>
	<a href="<c:url value='index.jsp'/>">Back</a>

</body>
</html>