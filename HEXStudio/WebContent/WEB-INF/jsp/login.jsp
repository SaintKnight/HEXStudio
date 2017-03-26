<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h2>User Login</h2>
	<form:form method="POST" action="/HEXStudio/loginoutresult">
		<table>
			<tr>
				<td><form:label path="username">User Name</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="url" value="${param.url}" />
	</form:form>
	<form action="/HEXStudio${param.url}">
		<input type="submit" value="back" />
	</form>
</body>
</html>