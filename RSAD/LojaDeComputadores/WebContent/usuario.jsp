<%@page import="model.UsuarioVendedor"%>
<%@page import="model.UsuarioGerente"%>
<%@page import="model.Usuario"%>
<%@page import="model.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cargo"%>
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
<title>Insert title here</title>
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
		<div class="row">
			<div class="col-sm-10">
				<h1>Novo Usuário</h1>
			</div>
			<div class="col-sm-2">
				<button id="btnEditar" class="btn btn-warning btnForm">
					<span class="glyphicon glyphicon-pencil"></span> Editar
				</button>
			</div>
		</div>
		
		<form action="AtualizarUsuarioController" method="post">
			<div class="row linhaForm">
				<% Usuario usuario = (Usuario) request.getAttribute("usuarioSelecionado"); %>
				<input type="hidden" name="id" value="<%= usuario.getId() %>"/>				
				<div class="col-sm-1 labelForm">
					Nome:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="nome" value="<%= usuario.getNome() %>" disabled/>
				</div>
				<div class="col-sm-1 labelForm">
					CPF:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="cpf" value="<%= usuario.getCpf() %>" disabled id="CPF"/>
				</div>
				<div class="col-sm-1 labelForm">
					Cargo:
				</div>
				<div class="col-sm-3">
					<select class="form-control" name="cargo" disabled>
					<%
						ArrayList<Cargo> cargos = (ArrayList<Cargo>) request.getAttribute("listaCargos");
						for(Cargo cargo: cargos){
					%>
	    				<option <%= usuario.getCargo().getId() == cargo.getId() ? "selected":"" %> value="<%=cargo.getId()%>"><%=cargo.getNome()%></option>
	    			<%}%>
	  				</select>
				</div>
				
			</div>
			<div class="row linhaForm">
				<div class="col-sm-1 labelForm">
					Login:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="login" value="<%= usuario.getLogin() %>" disabled/>
				</div>
				<div class="col-sm-1 labelForm">
					Senha:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="senha" value="<%= usuario.getSenha() %>" disabled/>
				</div>
				<div class="col-sm-1 labelForm">
					Tipo:
				</div>
				<div class="col-sm-3">
					<select class="form-control" name="tipo" disabled>
					<%
						List<TipoUsuario> tipos = (List<TipoUsuario>) request.getAttribute("listaTipos");
						
						for(TipoUsuario tipo: tipos){
					%>
	    				<option <%= (usuario instanceof UsuarioGerente && tipo == TipoUsuario.GERENTE)
	    							|| usuario instanceof UsuarioVendedor && tipo == TipoUsuario.VENDEDOR ? "selected":"" %>
	    							value="<%=tipo.getId()%>"><%=tipo.getNome()%></option>
	    			<%}%>
	  				</select>
				</div>
			</div>
			<button id="btnSalvar" type="submit" class="btn btn-warning btnForm escondido">
				<span class="glyphicon glyphicon-ok-circle"></span> Salvar
			</button>
		</form>
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
		$(document).ready(function(){
    		$('#btnEditar').click(function(){
    			$("input").removeAttr('disabled');
    			$("select").removeAttr('disabled');
    			$("#btnSalvar").removeClass("escondido");
    			$("#btnEditar").addClass("escondido");
    		});
    		
    		$('#CPF').mask('000.000.000-00', {
				reverse : true
			});
		});
		
	</script>
</body>
</html>
