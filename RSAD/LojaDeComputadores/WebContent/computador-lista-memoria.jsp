<%@page import="model.Componente"%>
<%@page import="model.Item"%>
<%@page import="model.ItemPedido"%>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/itens.css">
<title>Lista - Mem�rias</title>
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
					<span class="h1 text-warning" style="font-family: verdana">Mem�ria</span>
					<div style="float: right">
						<button id="btnBack" type="button" class="btn btn-default btn-lg"
							onclick="location.href='NovoPedidoController'">
							<span class="glyphicon glyphicon-circle-arrow-left"></span>
							Voltar
						</button>
					</div>
				</div>
				<%
					ArrayList<Memoria> listaMemoria = (ArrayList<Memoria>) request.getAttribute("listaMemoria");
					if(listaMemoria == null){
						%>
						<span style="font-family: verdana">N�o foram encontradas mem�rias</span>
						<%
					}
					else{ 
						for (Memoria mem : listaMemoria) {
				%>
				<a> 
					<span onclick="showModal('<%=mem.getId()%>', '<%=mem.getFabricante()%>', '<%=mem.getModelo()%>', '<%=mem.getCapacidade()%>', '<%=mem.getTipoMemoria().getNome()%>', '<%=mem.getPrecoFormat()%>')"
					class="col-sm-4 itemLista"> 
						<img src="img/memoria.jpg" class="img-thumbnail" /> <br> 
						<span> Fabricante: <b><%=mem.getFabricante()%></b></span> <br> 
						<span> Modelo: <b><%=mem.getModelo()%></b></span> <br> 
						<span> Capacidade: <b><%=mem.getCapacidade()%></b></span> <br> 
						<span> Tipo de mem�ria: <b><%=mem.getTipoMemoria().getNome()%></b></span> <br> 
						<span> Pre�o: <b>R$<%=mem.getPrecoFormat()%></b></span>
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
	<div id="modalItem" class="modal">
		<!-- Modal content -->
		<div class="modal-content-item">
			<span class="close">&times;</span>
			<form action="ComputadorMemoriaController?idPlaca=<%=request.getParameter("idPlaca") %>&idProcessador=<%=request.getParameter("idProcessador") %>" method="post">
				<input type="hidden" name="idMemoria" id="modalId">
				<input type="hidden" name="pentesSobrando" value="<%=request.getParameter("numeroPentesSobrando")%>">
				<div class="col-sm-4" style="margin-top:20px">
					<img src="img/memoria.jpg" class="img-thumbnail" /> 
					<div class="input-group" style="margin-top: 5px">
          				<span class="input-group-btn">
              				<button type="button" class="btn btn-danger btn-number"  data-type="minus" data-field="quantidade">
                				<span class="glyphicon glyphicon-minus"></span>
              				</button>
          				</span>
          				<input type="text" name="quantidade" class="form-control input-number" value="1" min="1" max="<%=request.getParameter("numeroPentesSobrando")%>">
          				<span class="input-group-btn">
              			<button type="button" class="btn btn-success btn-number" data-type="plus" data-field="quantidade">
                  			<span class="glyphicon glyphicon-plus"></span>
              			</button>
          				</span>
      				</div>
      				<br>
      				Adicionar outras memorias?
      				<br>
      				<label class="radio-inline"><input type="radio" name="adicionarOutras" value="false" checked="checked" id="radioFalse">N�o</label>
					<label class="radio-inline"><input type="radio" name="adicionarOutras" value="true" id="radioTrue" <%= Integer.parseInt(request.getParameter("numeroPentesSobrando")) == 1 ? "disabled":""%>>Sim</label>
					<input style="margin-top: 10px" id="buttonAdd" class="btn btn-primary" type="submit" value="Selecionar" />
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
					<label class="col-sm-3 col-form-label" for="modalCapacidade">Capacidade</label>
					<div class="col-sm-7">
						<input type="text" name="capacidade" class="form-control" readonly id="modalCapacidade" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 col-form-label" for="modalTipoMemoria">Tipo de mem�ria</label>
					<div class="col-sm-7">
						<input type="text" name="tipo" class="form-control" readonly id="modalTipo" />
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
	<div id="modalCPF" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<span class="closecpf">&times;</span>
			<form action="NovoPedidoController" method="post">
				<input placeholder="Digite o CPF" type="text" name="cpf" id="CPF"
					class="txtArea" /> <input id="buttonCPF" class="btn btn-primary"
					type="submit" value="Enviar" />
				<div class="limpar"></div>
			</form>
		</div>
	</div>
	<script>
		function showModal(id, fabricante, modelo, capacidade, tipo,
			preco) {
			modal.style.display = "block";
			document.getElementById("modalFabricante").value = fabricante;
			document.getElementById("modalModelo").value = modelo;
			document.getElementById("modalTipo").value = tipo;
			document.getElementById("modalCapacidade").value = capacidade;
			document.getElementById("modalPreco").value = preco;
			document.getElementById("modalId").value = id;
		}
		$(document).ready(function() {
	    $('input[type=text][name=quantidade]').change(function() {
	    	var numeroPentes = $('input[type=hidden][name=pentesSobrando]').val();
	        if (numeroPentes - this.value == 0) {
	            $('#radioFalse').prop('checked', true);
	            $('#radioTrue').prop('disabled', true);
	        }else{
	        	$('#radioTrue').prop('disabled', false);
	        }
    	});
	});
	</script>
	<script src="js/plus-minus-button.js"></script>
	<script src="js/modalCPF.js"></script>
</body>
</html>
