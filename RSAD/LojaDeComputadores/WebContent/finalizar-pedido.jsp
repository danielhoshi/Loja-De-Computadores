<%@page import="model.Componente"%>
<%@page import="model.Memoria"%>
<%@page import="model.Processador"%>
<%@page import="model.Item"%>
<%@page import="model.ItemPedido"%>
<%@page import="model.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

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

	<link rel="stylesheet" type="text/css" href="css/style.css">
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
		<% 
		Pedido p = (Pedido) request.getSession().getAttribute("pedido");
		%>
			<div class="detalhesCompra">
				<div class="row">
					<h1>Detalhes da Compra</h1>
				</div>
				<div class="row dadosFinalizar">
					<div class="col-sm-3">
						<div class="row">
							<span class="precoTxt">Preço Total:</span>
							<span class="precoTotal">
								R$ 
								<span id="preco"><%=p.getPrecoTotalFormat()%></span>
							</span>
						</div>
						<div class="row">
							<span class="precoTxt text-danger">Desconto:</span>
							<span class="precoTotal text-danger">
								-R$ 
								<span id="preco"><%=p.getDescontoFormat()%></span>
							</span>
						</div>
						<hr>
						<div class="row">
							<span class="precoTxtFinal">Preço Final:</span>
							<span class="precoTotalFinal">
								R$ 
								<span id="preco"><%=p.getPrecoFinalFormat()%></span>
							</span>
						</div>
					</div>
					<div class="col-sm-5 buttonsfinalizar">
						<button id="finalizar" class="btn btn-success">Finalizar Compra</button>
						<button id="cancelar" class="btn btn-danger">Cancelar</button>
						<button id="voltar" class="btn btn-primary">Voltar</button>
					</div>
				</div>
			</div>
		
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
	<script src="js/modalCPF.js"></script>
	<script src="js/validateCPF.js"></script>
</body>
</html>