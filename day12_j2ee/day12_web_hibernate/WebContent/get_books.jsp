
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
				<td>Enter Publish Date</td>
				<td><input type="text" name="pubDate" /></td>
			</tr>
			<tr>
				<td>Enter Book Author</td>
				<td><input type="text" name="author" /></td>
			</tr>
			

			<tr>
				<td><input name="btn" type="submit" value="Get Book" /></td>
			</tr>
		</table>
	</form>
	<c:if test="${param.btn eq 'Get Book'}">
		<jsp:setProperty property="*" name="book" />
	<c:forEach  var="bk" items="${sessionScope.book.booksByAuthor}">
	${bk.title} ${bk.author} ${bk.price}<br/>
	</c:forEach>
	</c:if>
	<a href="<c:url value='index.jsp'/>">Back</a>

</body>
</html>