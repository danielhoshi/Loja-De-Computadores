<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista Usu�rios</h1>
	<%
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("listaUsuarios");
		for(Usuario usuario:usuarios){
	%>
		<p>ID: <%= usuario.getId() %></p>
		<p>
			Nome:
			<a href="UsuarioController?id=<%= usuario.getId() %>">
				<%= usuario.getNome() %>
			</a>
		</p>
	<%} %>
	<br>
	<a href="index.jsp">Index</a>
</body>
</html>