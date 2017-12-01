<%@page import="model.Pedido"%>
<%@page import="model.Cliente"%>
<%@page import="model.Usuario"%>
<%@page import="model.Memoria"%>
<%@page import="java.util.ArrayList"%>
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

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/itens.css">
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
		<div class="row" style="height: 700px">
			<div class="col-sm-9" id="tipos">
				<div class="row" style="margin: 50px">
					<span class="h1" style="font-family: verdana">Memória</span>
					<div style="float: right">
						<button id="btnBack" type="button" class="btn btn-default btn-lg" onclick="location.href='NovoPedidoController'">
							<span class="glyphicon glyphicon-circle-arrow-left"></span>
							Voltar
						</button>
					</div>
				</div>
				<%
					ArrayList<Memoria> listaMemoria = (ArrayList<Memoria>) request.getAttribute("lista");
					for (Memoria mem : listaMemoria) {
				%>
				<a href="#"> <span class="col-sm-4 itemLista"> <img
						src="img/memoria.jpg" class="img-thumbnail" /> <br>
					<span> Fabricante: <b><%=mem.getFabricante()%></b>
					</span> <br> <span> Modelo: <b><%=mem.getModelo()%></b>
					</span> <br> <span> Capacidade: <b><%=mem.getCapacidade()%></b>
					</span> <br> <span> Tipo de memória: <b><%=mem.getTipoMemoria().getNome()%></b>
					</span> <br> <span> Preço: <b>R$<%=mem.getPrecoFormat()%></b>
					</span>
				</span>
				</a>
				<%
					}
				%>
			</div>
			<div class="col-sm-3" id="status">
				<%
					Pedido p = (Pedido) request.getSession().getAttribute("pedido");
					Usuario u = (Usuario) request.getSession().getAttribute("usuario");
					Cliente c = p.getCliente();
				%>
				<div class="info">
					<span>Vendedor: <b><%=u.getNome()%></b></span> <br> <span>CPF
						do Cliente: <b><%=c.getCPF()%></b>
					</span> <br>
				</div>
				<div class="dados">
					<span class="qtd">3 Itens Selecionados</span> <span class="itens">
						<span class="item"> <img src="images/sample1.jpg"
							class="img-thumbnail"> <span class="nome">Intel Core
								2 Duo</span> <span class="tipo">Processador</span>
					</span>
					</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>