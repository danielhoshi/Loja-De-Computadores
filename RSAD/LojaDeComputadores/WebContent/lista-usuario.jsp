<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="model.UsuarioGerente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/usuario.css">
<title>Usuários</title>
</head>
<body>
	<nav class="navbar" data-spy="affix">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navItems">
					<span class="glyphicon glyphicon-menu-hamburger"></span>
				</button>
				<a class="navbar-brand" href="#"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span></a>
			</div>

			<div class="collapse navbar-collapse" id="navItems">
				<ul class="nav navbar-nav">
					<li><a href="#" id="btnPedido">Fazer Pedido</a></li>
					<li><a href="UsuarioController">Usuários</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row listHeader">
			<div class="col-sm-10">
				<h1>Usuários</h1>
			</div>
			<div class="col-sm-2">
				<a href="CadastroUsuarioController" class="btn btn-warning">
					<span class="glyphicon glyphicon-plus"></span> Novo Usuário
				</a>
			</div>	
		</div>
		<div class="row">
		<div class="col-sm-12">
			<div class="table-responsive">          
			<table class="table">
				<thead>
	 				<tr>
	 					<th>id</th>
	 					<th>Nome</th>
	 					<th>Cpf</th>
	 					<th>Cargo</th>
	 				</tr>
 				</thead>
 				<tbody>
	 				<%
						ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("listaUsuarios");
						for(Usuario usuario:usuarios){
					%>
					<tr class="<%= (request.getParameter("novo") != null && request.getParameter("novo").equals(usuario.getId().toString())) ? "success":""%>">
	 					<td><%= usuario.getId() %></td>
	 					<td>
	 						<%= usuario.getNome() %>
	 						<%
	 							if(usuario instanceof UsuarioGerente){
	 						 %>
	 						 <span class="glyphicon glyphicon-user" title="Usuário Gerente"></span>
	 						 <%} %>
	 					</td>
	 					<td><%= usuario.getCpf() %></td>
	 					<td><%= usuario.getCargo().getNome() %></td>
	      			</tr>
					<%} %>
				</tbody>
			</table>
			</div>
		</div>
		</div>
	</div>

	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<form action="">
				<input placeholder="Digite o CPF do cliente" type="text" name="cpf" class="txtArea"/>
				<input id="buttonCPF" class="btn btn-primary" type="submit"/>
				<div class="limpar"></div>
			</form>
		</div>

	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the button that opens the modal
		var btn = document.getElementById("btnPedido");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks the button, open the modal 
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>