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
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>

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
		<div class="row" style="height: 700px"></div>
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