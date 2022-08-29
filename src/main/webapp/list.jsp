<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="clientDAO" class="dao.ClientDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.html">Back to home</a>
	<br>
	<br>
	<form action="update.jsp" method="post">
		<label>Enter ID for UpDate<input type="number" name="id"></label>
		<input type="submit" value="Update">
	</form>
	<br>
	<form action="delete" method="post">
		<label>Enter ID for Delete&nbsp <input type="number" name="id"></label>
		<input type="submit" value="Delete">
	</form>
	<br>
	<hr>
	<hr>
	<hr>
	<hr>
	<hr>
	<table id="tabela" border="1px solid">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Type of Service</th>
				<th>Message</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < clientDAO.list().size(); i++) {
			%>
			<tr>
				<td><%=clientDAO.list().get(i).getId()%></td>
				<td><%=clientDAO.list().get(i).getName()%></td>
				<td><%=clientDAO.list().get(i).getEmail()%></td>
				<td><%=clientDAO.list().get(i).getPhone()%></td>
				<td><%=clientDAO.list().get(i).getType_of_service()%></td>
				<td><%=clientDAO.list().get(i).getMessage()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br>

	<form action="update.jsp" method="post">
		<label>Enter ID for UpDate<input type="number" name="id"></label>
		<input type="submit" value="Update">
	</form>
	<br>
	<form action="delete" method="post">
		<label>Enter ID for Delete&nbsp <input type="number" name="id"></label>
		<input type="submit" value="Delete">
	</form>
	<br>
	<br>
	<hr>
	<hr>
	<hr>
	<hr>
	<hr>
</body>
</html>