<%@page import="model.Componente"%>
<%@page import="model.Memoria"%>
<%@page import="model.Processador"%>
<%@page import="model.Item"%>
<%@page import="model.ItemPedido"%>
<%@page import="model.Pedido"%>
<%@page import="model.Cliente"%>
<%@page import="model.Usuario"%>
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
				<a href="ComputadorController">
					<span class="tipoItem">
						<img src="img/computador.jpg" class="img-thumbnail">
						<span>Computador</span>
					</span>
				</a>
				<a href="PlacaController">
				<span class="tipoItem">
					<img src="img/placamae.jpg" class="img-thumbnail">
					<span>Placa Mãe</span>
				</span>
				</a>
				<a href="ProcessadorController">
				<span class="tipoItem">
					<img src="img/processador.jpg" class="img-thumbnail">
					<span>Processador</span>
				</span>
				</a>
				<a href="HDController">
				<span class="tipoItem">
					<img src="img/hd.jpg" class="img-thumbnail">
					<span>Disco Rígido</span>
				</span>
				</a>
				<a href="MemoriaController">
				<span class="tipoItem">
					<img src="img/memoria.jpg" class="img-thumbnail">
					<span>Pente de Memória</span>
				</span>
				</a>
			</div>
			<div class="col-sm-3" id="status">
				<% 
					Pedido p = (Pedido) request.getSession().getAttribute("pedido");
					Usuario u = (Usuario) request.getSession().getAttribute("usuario");
					Cliente c = p.getCliente();
				 %>
				<div class="info">
					<img src="img/fotinho.jpg" class="fotoVendedor img-circle img-thumbnail"/>
					<span>Vendedor: <b><%=u.getNome() %></b></span> 
					<br>
					<span>CPF do Cliente: <b><%=c.getCPF() %></b></span>
					<br>
				</div>
				<div class="dados">
					<%if(p.getItemPedido().isEmpty()){%>
					<span class="qtd">Nenhum item selecionado</span>
					<%
					} else{
						int size = p.getItemPedido().size();
					%>
					<span class="qtd"><%=size > 1 ? size +" itens selecionados" : "1 item selecionado"%></span>
					<%} %>
					<div class="itens">
						<%
						for(ItemPedido ip : p.getItemPedido()){
							Item item = ip.getItem();
							String label;
							String tipo;
							if(item instanceof Componente){
								label = ((Componente)item).getFabricante() + " - "+ ((Componente)item).getModelo();
								if(label.length()>20){
									label = label.substring(0,18)+"...";
								}
							}else{
								label = "Computador";
							}
						%>
						<div class="item">
							<img src="img/<%= item.getClass().getSimpleName().toLowerCase() %>.jpg" class="img-thumbnail">
							<span class="labelItem">
								<span class="descricaoItem"><%=label%></span>
								<span class="qtdItem">(x<%=ip.getQtd()%>)</span>
							</span>
							<div class="limpar"></div>
						</div>
						<%} %>
					</div>
				</div>
			</div>
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