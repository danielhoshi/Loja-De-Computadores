<%@page import="model.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Cargo"%>
<!DOCTYPE html>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/usuario.css">
<title>Cadastro de Usuário</title>
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
		<h1 class="text-warning" style="margin-left: 30px;">Novo Usuário</h1>
		<form data-toggle="validator" role="form" action="CadastroUsuarioController" method="post">
			<div class="row linhaForm">
  				<div class="form-group" style="margin-bottom: 0">
					<div class="col-sm-1 labelForm">
					Nome:
					</div>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="nome" required/>
					</div>
				</div>
				<div class="form-group" style="margin-bottom: 0">
					<div class="col-sm-1 labelForm">
					CPF:
					</div>
					<div class="col-sm-3">
						<input type="text" class="form-control cpf" name="cpf" id="CPF" required/>
						<p id="invalidUserCpf" class="font-weight-light text-danger text-center">CPF inválido</p>
					</div>
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
				<div class="form-group" style="margin-bottom: 0">
					<div class="col-sm-1 labelForm">
						Login:
					</div>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="login" required/>
					</div>
				</div>
				<div class="form-group" style="margin-bottom: 0">
					<div class="col-sm-1 labelForm">
						Senha:
					</div>
					<div class="col-sm-3">
						<input type="password" class="form-control" name="senha" data-minlength="1" required/>
					</div>
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
			<button type="submit" class="btn btn-warning btnForm"  style="margin: 10px 0 30px 30px;" id="btnCadastrar">
				<span class="glyphicon glyphicon-ok-circle"></span> Salvar
			</button>
		</form>
	</div>
	<div id="modalCPF" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<span class="closecpf">&times;</span>
			<form action="NovoPedidoController" method="post">
				<input placeholder="Digite o CPF" type="text" name="cpf" id="modalTxt" class="txtArea cpf" /> 
				<div class="row">
					<div class="col-sm-4">
						<input id="buttonCPF" class="btn btn-primary" type="submit" value="Enviar" />
					</div>
					<div class="col-sm-8">
						<p style="margin-top: 10px" id="invalidCpf" class="font-weight-light text-danger text-center">CPF inválido</p>
					</div>
					<div class="limpar"></div>
				</div>
			</form>
		</div>
	</div>
	<script>
	$(document).ready(function() {
		$('.cpf').keyup(function() {
			if (validarCPF($(this).val())) {
				$('#btnCadastrar').prop('disabled', false);
				$('#invalidUserCpf').hide();
			} else {
				$('#btnCadastrar').prop('disabled', true);
				$('#invalidUserCpf').show();
			}
		});
	});
	</script>
	<script src="js/modalCPF.js"></script>
	<script src="js/validateCPF.js"></script>
</body>
</html>
