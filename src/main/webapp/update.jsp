<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="clientDAO" class="dao.ClientDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int id = Integer.parseInt(request.getParameter("id")); %>
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
			<form action="update" method="post">
				<tr>
					<td><input type="number" name="id" value="<%=clientDAO.find(id).getId()%>" readonly="readonly"></td>
					<td><input type="text" name="name" value="<%=clientDAO.find(id).getName()%>"></td>
					<td><input type="text" name="email" value="<%=clientDAO.find(id).getEmail()%>"></td>
					<td><input type="number" name="phone" value="<%=clientDAO.find(id).getPhone()%>"></td>
					<td><input type="text" name="type_of_service" value="<%=clientDAO.find(id).getType_of_service()%>"></td>
					<td><input type="text" name="message" value="<%=clientDAO.find(id).getMessage()%>"></td>
				</tr>
				<input type="submit" value="UpDate">
		</form>
		</tbody>
		
	</table>

</body>
</html>