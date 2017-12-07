<%@page import="model.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>

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
				<a class="navbar-brand" href="/LojaDeComputadores/"><span
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
		<h1>Novo Usuário</h1>
		<form action="CadastroUsuarioController" method="post">
			<div class="row linhaForm">
				<div class="col-sm-1 labelForm">
					Nome:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="nome"/>
				</div>
				<div class="col-sm-1 labelForm">
					CPF:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="cpf" id="CPF"/>
				</div>
				<div class="col-sm-1 labelForm">
					Cargo:
				</div>
				<div class="col-sm-3">
					<select class="form-control" name="cargo">
					<%
						ArrayList<Cargo> cargos = (ArrayList<Cargo>) request.getAttribute("listaCargos");
						for(Cargo cargo: cargos){
					%>
	    				<option value="<%=cargo.getId()%>"><%=cargo.getNome()%></option>
	    			<%}%>
	  				</select>
				</div>
				
			</div>
			<div class="row linhaForm">
				<div class="col-sm-1 labelForm">
					Login:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="login"/>
				</div>
				<div class="col-sm-1 labelForm">
					Senha:
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="senha"/>
				</div>
				<div class="col-sm-1 labelForm">
					Tipo:
				</div>
				<div class="col-sm-3">
					<select class="form-control" name="tipo">
					<%
						List<TipoUsuario> tipos = (List<TipoUsuario>) request.getAttribute("listaTipos");
						
						for(TipoUsuario tipo: tipos){
					%>
	    				<option value="<%=tipo.getId()%>"><%=tipo.getNome()%></option>
	    			<%}%>
	  				</select>
				</div>
			</div>
			<button type="submit" class="btn btn-warning btnForm">
				<span class="glyphicon glyphicon-ok-circle"></span> Salvar
			</button>
		</form>
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
