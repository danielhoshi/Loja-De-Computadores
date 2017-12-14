<%@page import="model.Componente"%>
<%@page import="model.Memoria"%>
<%@page import="model.Processador"%>
<%@page import="model.Computador"%>
<%@page import="model.PlacaMae"%>
<%@page import="model.HD"%>
<%@page import="model.Item"%>
<%@page import="model.ItemPedido"%>
<%@page import="model.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat" %>
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
	<title>Finalizar Pedido</title>
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
		DecimalFormat df = new DecimalFormat("#,##0.00");
		%>
		<div class="detalhesCompra detalhes">
			<div class="row" style="margin-bottom: 30px; margin-left: 30px">
				<h1 class="text-warning">Detalhes da Compra</h1>
			</div>
			<div class="row">
				<div class="col-sm-4 dadosFinalizar">
					<div class="row">
						<span class="precoTxt">Preço Total:</span>
						<span class="precoTotal">
							R$ 
							<span id="preco"><%=df.format(p.getPrecoFinal() + p.getDesconto())%></span>
						</span>
					</div>
					<div class="row">
						<span class="precoTxt text-danger">Desconto:</span>
						<span class="precoTotal text-danger">
							-R$ 
							<span id="preco"><%=df.format(p.getDesconto())%></span>
						</span>
					</div>
					<hr style="margin: 7px 0 7px">
					<div class="row">
						<span class="precoTxtFinal">Preço Final:</span>
						<span class="precoTotalFinal">
							R$ 
							<span id="preco"><%=df.format(p.getPrecoFinal())%></span>
						</span>
					</div>
				</div>
				<div class="buttonsfinalizar">
					<div class="col-sm-5 ">
						<a href="SalvarPedidoController" id="finalizar" class="btn btn-success">Finalizar Compra</a>
					</div>
					<div class="col-sm-5">
						<a href="CancelarPedidoController"  id="cancelar" class="btn btn-danger">Cancelar</a>
					</div>
					<div class="col-sm-5">
						<a href="pedido.jsp" id="voltar" class="btn btn-primary">Voltar</a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="detalhesPedido">
			<div class="row" style="margin-bottom: 30px; margin-left: 30px">
				<h1 class="text-warning">Detalhes do Pedido</h1>
				<div id="itens">
					<div id="listaComputadores">
					<% 
						List<ItemPedido> listaComputadores = p.getItemLista(Computador.class);
						if(listaComputadores != null && !listaComputadores.isEmpty()){
					%>
						
						<div class="tipo_item row">
							<div class="col-sm-9">
								Computadores
							</div>
							<div class="col-sm-2 right">
								R$ 
								<%=df.format(p.getPrecoLista(listaComputadores))%>
							</div>
							<a data-toggle="collapse" data-target="#computadores" class="col-sm-1"> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>
						<div class="collapse" id="computadores">
							<ul>
								<%
									for(ItemPedido ip : listaComputadores){
								%>
								<li>
									<div class="row">
										<div class="col-sm-1">
											<img src="img/computador.jpg" class="img-circle border" alt="Computadores" width="50" height="50">
										</div>
										<div class="col-sm-8">
											<%=ip.getItem().getNome() %>
										</div>
										<div class="col-sm-2 right">
											R$
											<%=df.format(ip.getItem().getPreco())%>
										</div>
										<div class="col-sm-1">
											x
											<%=ip.getQtd() %>
										</div>
									</div>
								</li>
								<%
									}
								%>
							</ul>
						</div>
					<%} %>
					</div>
					<div id="listaProcessadores">
					<% 
						List<ItemPedido> listaProcessadores = p.getItemLista(Processador.class);
						if(listaProcessadores != null && !listaProcessadores.isEmpty()){
					%>
						
						<div class="tipo_item row">
							<div class="col-sm-9">
								Processadores
							</div>
							<div class="col-sm-2 right">
								R$ 
								<%=df.format(p.getPrecoLista(listaProcessadores))%>
							</div>
							<a data-toggle="collapse" data-target="#processadores" class="col-sm-1"> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>
						<div class="collapse" id="processadores">
							<ul>
								<%
									for(ItemPedido ip : listaProcessadores){
								%>
								<li>
									<div class="row">
										<div class="col-sm-1">
											<img src="img/processador.jpg" class="img-circle border" alt="Processadores" width="50" height="50">
										</div>
										<div class="col-sm-7">
											<%=ip.getItem().getNome() %>
										</div>
										<div class="col-sm-2 right">
											R$
											<%=df.format(ip.getItem().getPreco())%>
										</div>
										<div class="col-sm-1">
											x<%=ip.getQtd() %>
										</div>
										<div class="col-sm-1">
											<a href="RemoverItemController?idItem=<%=ip.getItem().getIdItem() %>" class="btn btn-danger btn-sm">
												<span class="glyphicon glyphicon-remove"></span>
											</a>
										</div>
									</div>
								</li>
								<%
									}
								%>
							</ul>
						</div>
					<%} %>
					</div>
					<div id="listaPlacas">
					<% 
						List<ItemPedido> listaPlacas = p.getItemLista(PlacaMae.class);
						if(listaPlacas != null && !listaPlacas.isEmpty()){
					%>
						
						<div class="tipo_item row">
							<div class="col-sm-9">
								Placas-Mãe
							</div>
							<div class="col-sm-2 right">
								R$ 
								<%=df.format(p.getPrecoLista(listaPlacas))%>
							</div>
							<a data-toggle="collapse" data-target="#placasmae" class="col-sm-1"> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>
						<div class="collapse" id="placasmae">
							<ul>
								<%
									for(ItemPedido ip : listaPlacas){
								%>
								<li>
									<div class="row">
										<div class="col-sm-1">
											<img src="img/placamae.jpg" class="img-circle border" alt="Placas-mae" width="50" height="50">
										</div>
										<div class="col-sm-7">
											<%=ip.getItem().getNome() %>
										</div>
										<div class="col-sm-2 right">
											R$
											<%=df.format(ip.getItem().getPreco())%>
										</div>
										<div class="col-sm-1">
											x
											<%=ip.getQtd() %>
										</div>
										<div class="col-sm-1">
											<a href="RemoverItemController?idItem=<%=ip.getItem().getIdItem() %>" class="btn btn-danger btn-sm">
												<span class="glyphicon glyphicon-remove"></span>
											</a>
										</div>
									</div>
								</li>
								<%
									}
								%>
							</ul>
						</div>
					<%} %>
					</div>
					<div id="listaHd">
					<% 
						List<ItemPedido> listaHd = p.getItemLista(HD.class);
						if(listaHd != null && !listaHd.isEmpty()){
					%>
						
						<div class="tipo_item row">
							<div class="col-sm-9">
								HDs
							</div>
							<div class="col-sm-2 right">
								R$ 
								<%=df.format(p.getPrecoLista(listaHd))%>
							</div>
							<a data-toggle="collapse" data-target="#hds" class="col-sm-1"> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>
						<div class="collapse" id="hds">
							<ul>
								<%
									for(ItemPedido ip : listaHd){
								%>
								<li>
									<div class="row">
										<div class="col-sm-1">
											<img src="img/hd.jpg" class="img-circle border" alt="HDs" width="50" height="50">
										</div>
										<div class="col-sm-7">
											<%=ip.getItem().getNome() %>
										</div>
										<div class="col-sm-2 right">
											R$
											<%=df.format(ip.getItem().getPreco())%>
										</div>
										<div class="col-sm-1">
											x
											<%=ip.getQtd() %>
										</div>
										<div class="col-sm-1">
											<a href="RemoverItemController?idItem=<%=ip.getItem().getIdItem() %>" class="btn btn-danger btn-sm">
												<span class="glyphicon glyphicon-remove"></span>
											</a>
										</div>
									</div>
								</li>
								<%
									}
								%>
							</ul>
						</div>
					<%} %>
					</div>
					<div id="Memorias">
					<% 
						List<ItemPedido> listaMemorias = p.getItemLista(Memoria.class);
						if(listaMemorias != null && !listaMemorias.isEmpty()){
					%>
						
						<div class="tipo_item row">
							<div class="col-sm-9">
								Pentes de memória
							</div>
							<div class="col-sm-2 right">
								R$ 
								<%=df.format(p.getPrecoLista(listaMemorias))%>
							</div>
							<a data-toggle="collapse" data-target="#memorias" class="col-sm-1"> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						</div>
						<div class="collapse" id="memorias">
							<ul>
								<%
									for(ItemPedido ip : listaMemorias){
								%>
								<li>
									<div class="row">
										<div class="col-sm-1">
											<img src="img/memoria.jpg" class="img-circle border" alt="Memorias" width="50" height="50">
										</div>
										<div class="col-sm-7">
											<%=ip.getItem().getNome() %>
										</div>
										<div class="col-sm-2 right">
											R$
											<%=df.format(ip.getItem().getPreco() )%>
										</div>
										<div class="col-sm-1">
											x
											<%=ip.getQtd() %>
										</div>
										<div class="col-sm-1">
											<a href="RemoverItemController?idItem=<%=ip.getItem().getIdItem() %>" class="btn btn-danger btn-sm">
												<span class="glyphicon glyphicon-remove"></span>
											</a>
										</div>
									</div>
								</li>
								<%
									}
								%>
							</ul>
						</div>
					<%} %>
					</div>
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