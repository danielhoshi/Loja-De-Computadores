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
					<li><a href="pedido.html">Fazer Pedido</a></li>
					<li><a href="#">Cadastrar Usuário</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row" style="height: 700px">
			<div class="col-sm-9" id="tipos">
				<a href="#">
					<span class="tipoItem">
						<img src="images/sample1.jpg" class="img-thumbnail">
						<span>Computador</span>
					</span>
				</a>
				<a href="#">
				<span class="tipoItem">
					<img src="images/sample1.jpg" class="img-thumbnail">
					<span>Placa Mãe</span>
				</span>
				</a>
				<a href="#">
				<span class="tipoItem">
					<img src="images/sample1.jpg" class="img-thumbnail">
					<span>Processador</span>
				</span>
				</a>
				<a href="#">
				<span class="tipoItem">
					<img src="images/sample1.jpg" class="img-thumbnail">
					<span>Disco Rígido</span>
				</span>
				</a>
				<a href="#">
				<span class="tipoItem">
					<img src="images/sample1.jpg" class="img-thumbnail">
					<span>Pente de Memória</span>
				</span>
				</a>
			</div>
			<div class="col-sm-3" id="status">
				<span class="dados">
					<span class="qtd">3 Itens Selecionados</span>
					<span class="itens">
						<span class="item">
						<img src="images/sample1.jpg" class="img-thumbnail">
						<span class="nome">Intel Core 2 Duo</span>
						<span class="tipo">Processador</span>
						</span>
					</span>
				</span>
			</div>
		</div>
	</div>
</body>
</html>