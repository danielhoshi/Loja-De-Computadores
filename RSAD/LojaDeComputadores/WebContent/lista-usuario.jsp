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
		<% ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("listaUsuarios"); %>
		<% if(usuarios.isEmpty()){ %>
		<center><p>Nenhum Usuário Cadastrado</p></center>
		<%}else{ %>
		<div class="col-sm-12">
			<div class="table-responsive">          
			<table class="table table-striped">
				<thead>
	 				<tr>
	 					<th>id</th>
	 					<th>Nome</th>
	 					<th>Cpf</th>
	 					<th>Cargo</th>
	 					<th>Excluir</th>
	 				</tr>
 				</thead>
 				<tbody>
	 				<%
						for(Usuario usuario:usuarios){
					%>
					<tr class="<%= (request.getParameter("novo") != null && request.getParameter("novo").equals(usuario.getId().toString())) ? "success":""%>">
	 					<td><%= usuario.getId() %></td>
	 					<td>
	 						<a href="SelecionarUsuarioController?id=<%=usuario.getId()%>"><%= usuario.getNome() %></a>
	 						<%
	 							if(usuario instanceof UsuarioGerente){
	 						 %>
	 						 <span class="glyphicon glyphicon-user" title="Usuário Gerente"></span>
	 						 <%} %>
	 					</td>
	 					<td><%= usuario.getCpf() %></td>
	 					<td><%= usuario.getCargo().getNome() %></td>
	 					<td>
	 						<a href="ExcluirUsuarioController?id=<%=usuario.getId() %>" class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-remove"></span>
							</a>
	 					</td>
	      			</tr>
					<%} %>
				</tbody>
			</table>
			</div>
		</div>
		<%} %>
		</div>
	</div>

	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<form action="NovoPedidoController" method="post">
				<input placeholder="Digite o CPF" type="text" name="cpf" id="CPF"
					class="txtArea" /> <input id="buttonCPF" class="btn btn-primary"
					type="submit" value="Enviar" />
				<div class="limpar"></div>
			</form>
		</div>
	</div>
	<script>
		//MODAL
		var modal = document.getElementById('myModal');
		var btn = document.getElementById('btnPedido');
		var span = document.getElementsByClassName("close")[0];
		btn.onclick = function() {
			modal.style.display = "block";
		}

		span.onclick = function() {
			modal.style.display = "none";
		}

		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}

		//MASCARA PARA CPF
		$(document).ready(function() {
			$('#CPF').mask('000.000.000-00', {
				reverse : true
			});
		});

	</script>
</body>
</html>