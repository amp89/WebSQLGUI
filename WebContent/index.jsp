<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>-SQL-</title>
<link rel="stylesheet" href="stylesheet.css" />
</head>

<header> SQL SEARCH </header>

<form action="performQuery.do" method="POST">
	<textarea name="query" /></textarea>
	<button id="submit-button" type="submit" value="query">Go</button>

	</button>
</form>
<!-- if there is an error message, print it -->
<c:choose>
<c:when test="${!empty(errorMessage)}">
	<div id="message">There was a problem with the SQL:<br>${errorMessage}</div>
</c:when>

<c:otherwise>
	<div id="message">Results:</div>
</c:otherwise>
</c:choose>

<c:if test="${results.rowsAffected > 0}">
	<div id="message">UPDATED. Rows Affected: ${results.rowsAffected}</div>
</c:if>

<!-- if there are results, print them in a table -->
<c:if test="${!empty(results)}">
	<table id="results-table">

		<tr>
			<c:forEach var="col" items="${results.columns}">
				<th>${col}</th>
			</c:forEach>
		</tr>

		<c:forEach var="row" items="${results.rows}">
			<tr>
				<c:forEach var="rowItem" items="${row}">
					<td>${rowItem}
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</c:if>

<body>

</body>
</html>