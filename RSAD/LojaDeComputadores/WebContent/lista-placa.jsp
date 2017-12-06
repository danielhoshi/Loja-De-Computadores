<%@page import="model.Pedido"%>
<%@page import="model.Cliente"%>
<%@page import="model.Usuario"%>
<%@page import="model.PlacaMae"%>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>

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
				<a class="navbar-brand" href="#">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
				</a>
			</div>
			<div class="collapse navbar-collapse" id="navItems">
				<ul class="nav navbar-nav">
					<li>
						<a href="#" id="btnPedido">Fazer Pedido</a>
					</li>
					<li>
						<a href="UsuarioController">Usu�rios</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row" style="height: 700px">
			<div class="col-sm-9" id="tipos">
				<div class="row" style="margin: 50px">
					<span class="h1" style="font-family: verdana">Placa-M�e</span>
					<div style="float: right">
						<button id="btnBack" type="button" class="btn btn-default btn-lg"
							onclick="location.href='NovoPedidoController'">
							<span class="glyphicon glyphicon-circle-arrow-left"></span>
							Voltar
						</button>
					</div>
				</div>
				<%
					ArrayList<PlacaMae> listaPlaca = (ArrayList<PlacaMae>) request.getAttribute("lista");
					if(listaPlaca == null){
				%>
						<span style="font-family: verdana">N�o foram encontradas placas-m�e</span>
				<%
					}
					else {
						for (PlacaMae placa : listaPlaca) {
				%>
				<a> 
					<span onclick="showModal('<%=placa.getId()%>', '<%=placa.getFabricante()%>', '<%=placa.getModelo()%>', '<%=placa.getSoquete().getNome()%>', '<%=placa.getNumeroDePentes()%>', '<%=placa.getPrecoFormat()%>')"
					class="col-sm-4 itemLista"> 
						<img src="img/placa.jpg" class="img-thumbnail" /> <br> 
						<span> Fabricante: <b><%=placa.getFabricante()%></b></span> <br> 
						<span> Modelo: <b><%=placa.getModelo()%></b></span> <br> 
						<span> Soquete: <b><%=placa.getSoquete().getNome()%></b></span> <br> 
						<span> Pentes de mem�ria: <b><%=placa.getNumeroDePentes()%></b></span> <br> 
						<span> Pre�o: <b>R$<%=placa.getPrecoFormat()%></b></span>
					</span>
				</a>
				<%
						}
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
					<span>Vendedor: <b><%=u.getNome()%></b></span> <br> 
					<span>CPF do Cliente: <b><%=c.getCPF()%></b></span> <br>
				</div>
				<div class="dados">
					<span class="qtd">3 Itens Selecionados</span> 
					<span class="itens">
						<span class="item"> 
							<span class="nome">Intel Core 2 Duo</span> 
							<span class="tipo">Processador</span>
						</span>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div id="modalItem" class="modal">
		<!-- Modal content -->
		<div class="modal-content-item">
			<span class="close">&times;</span>
			<form action="AdicionarItemController" method="post">
				<input type="hidden" name="id" id="modalId">
				<input type="hidden" name="tipoItem" id="modalId" value=1>
				<div class="col-sm-4" style="margin-top:20px">
					<img src="img/placa.jpg" class="img-thumbnail" /> 
					<div class="input-group" style="margin-top: 5px">
          				<span class="input-group-btn">
              				<button type="button" class="btn btn-danger btn-number"  data-type="minus" data-field="quantidade">
                				<span class="glyphicon glyphicon-minus"></span>
              				</button>
          				</span>
          				<input type="text" name="quantidade" class="form-control input-number" value="1" min="1" max="100">
          				<span class="input-group-btn">
              			<button type="button" class="btn btn-success btn-number" data-type="plus" data-field="quantidade">
                  			<span class="glyphicon glyphicon-plus"></span>
              			</button>
          				</span>
      				</div>
					<input style="margin-top: 10px" id="buttonAdd" class="btn btn-primary" type="submit" value="Adicionar" />
				</div>
				<div class="col-sm-8">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label" for="modalFabricante">Fabricante</label>
					<div class="col-sm-7">
						<input type="text" name="fabricante" class="form-control" readonly id="modalFabricante" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 col-form-label" for="modalModelo">Modelo</label>
					<div class="col-sm-7">
						<input type="text" name="modelo" class="form-control" readonly id="modalModelo" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 col-form-label" for="modalSoquete">Soquete</label>
					<div class="col-sm-7">
						<input type="text" name="soquete" class="form-control" readonly id="modalSoquete" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 col-form-label" for="modalMemorias">Pentes de mem�ria</label>
					<div class="col-sm-7">
						<input type="text" name="memorias" class="form-control" readonly id="modalMemorias" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 col-form-label" for="modalPreco">Pre�o</label>
					<div class="col-sm-7">
						<input type="text" name="preco" class="form-control" readonly id="modalPreco" />
					</div>
				</div>
				</div>
				<div class="limpar"></div>
			</form>
		</div>
	</div>
	<script src="js/modal-item.js"></script>
	<script>
		function showModal(id, fabricante, modelo, soquete, memorias,
				preco) {
			modal.style.display = "block";
			document.getElementById("modalFabricante").value = fabricante;
			document.getElementById("modalModelo").value = modelo;
			document.getElementById("modalSoquete").value = soquete;
			document.getElementById("modalMemorias").value = memorias;
			document.getElementById("modalPreco").value = preco;
			document.getElementById("modalId").value = id;
		}
	</script>	
	<script src="js/plus-minus-button.js"></script>
</body>
</html>