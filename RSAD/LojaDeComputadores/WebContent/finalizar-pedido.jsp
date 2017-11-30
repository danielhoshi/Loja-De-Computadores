<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<link rel="stylesheet" type="text/css" href="css/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Finalizar Pedido</title>
</head>
<body>
	<div class="container">
		<h1>Detalhes do Pedido</h1>
		<div id="itens">
			<div>
				<div class="tipo_item row">
					<div class="col-sm-9">Computadores</div>
					<div class="col-sm-2 right">R$ 10.000,00</div>
					<a data-toggle="collapse" data-target="#computadores"
						class="col-sm-1"> <span
						class="glyphicon glyphicon-chevron-down"></span>
					</a>
				</div>
				<div class="collapse" id="computadores">
					<ul>
						<li><div class="row">
								<div class="col-sm-1">
									<img src="
									img/computer.jpg"
										class="img-circle border" alt="Computadores" width="50"
										height="50">
								</div>
								<div class="col-sm-8">Computador com processador Intel i5
									7400, HD Seagate de 1TB, 1 pente de 4GB de memória DDR4 2133MHz
									da Kingston e placa mãe Asus Z170M-PLUS/BR</div>
								<div class="col-sm-2 right">R$ 6.000,00</div>
								<div class="col-sm-1">1x</div>
							</div></li>
						<li><div class="row">
								<div class="col-sm-1">
									<img src="
									img/computer.jpg"
										class="img-circle border" alt="Computadores" width="50"
										height="50">
								</div>
								<div class="col-sm-8">Computador com processador Intel i3
									7100, HD Seagate de 1TB, 2 pentes de 4GB de memória DDR4
									2133MHz da Kingston e placa mãe Asus Z170M-PLUS/BR</div>
								<div class="col-sm-2 right">R$ 4.000,00</div>
								<div class="col-sm-1">1x</div>
							</div></li>
					</ul>
				</div>
			</div>
			<div>
				<div class="tipo_item row">
					<div class="col-sm-9">Processadores</div>
					<div class="col-sm-2 right">R$ 1.000,00</div>
					<a data-toggle="collapse" data-target="#processadores"
						class="col-sm-1"> <span
						class="glyphicon glyphicon-chevron-down"></span>
					</a>
				</div>
				<div class="collapse" id="processadores">
					<ul>
						<li><div class="row">
								<div class="col-sm-1">
									<img src="
									img/processador.jpg"
										class="img-circle border" alt="Processadores" width="50"
										height="50">
								</div>
								<div class="col-sm-8">Intel i3 7100</div>
								<div class="col-sm-2 right">R$ 500,00</div>
								<div class="col-sm-1">2x</div>
							</div></li>
					</ul>
				</div>
			</div>
			<div>
				<div class="tipo_item row">
					<div class="col-sm-9">Placas-mãe</div>
					<div class="col-sm-2 right">R$ 0,00</div>
					<a data-toggle="collapse" data-target="#placas" class="col-sm-1">
						<span class="glyphicon glyphicon-chevron-down"></span>
					</a>
				</div>
				<div class="collapse" id="placas">
					<ul>

					</ul>
				</div>
			</div>
			<div>
				<div class="tipo_item row">
					<div class="col-sm-9">Discos Rígidos</div>
					<div class="col-sm-2 right">R$ 3.000,00</div>
					<a data-toggle="collapse" data-target="#discos" class="col-sm-1">
						<span class="glyphicon glyphicon-chevron-down"></span>
					</a>
				</div>
				<div class="collapse" id="discos">
					<ul>
						<li><div class="row">
								<div class="col-sm-1">
									<img src="
									img/disco.jpg" class="img-circle border"
										alt="Discos rígidos" width="50" height="50">
								</div>
								<div class="col-sm-8">SSD Kingston de 120GB</div>
								<div class="col-sm-2 right">R$ 300,00</div>
								<div class="col-sm-1 ">10x</div>
							</div></li>
					</ul>
				</div>
			</div>
			<div>
				<div class="tipo_item row">
					<div class="col-sm-9">Pentes de Memória</div>
					<div class="col-sm-2 right">R$ 0,00</div>
					<a data-toggle="collapse" data-target="#pentes" class="col-sm-1">
						<span class="glyphicon glyphicon-chevron-down"></span>
					</a>
				</div>
				<div class="collapse" id="pentes">
					<ul>

					</ul>
				</div>
			</div>
		</div>
		<div id="compra">

			<h1>Detalhes da Compra</h1>
			<div class="row" id="precos">
				<div class="row">
					<div class="col-sm-8">Preço total dos itens</div>
					<div class="col-sm-4 right">R$ 14.000,00</div>
				</div>
				<div class="row">
					<div class="col-sm-8">Custo de montagem</div>
					<div class="col-sm-4 right">R$ 300,00</div>
				</div>
				<div class="row desconto">
					<div class="col-sm-8">Desconto: Computador com processador
						Intel i5 7400, HD Seagate de 1TB, 1 pente de 4GB de memória DDR4
						2133MHz da Kingston e placa mãe Asus Z170M-PLUS/BR</div>
					<div class="col-sm-4 right">- R$ 600,00</div>
				</div>
				<div class="row desconto">
					<div class="col-sm-8">Desconto: Computador com processador
						Intel i3 7100, HD Seagate de 1TB, 2 pentes de 4GB de memória DDR4
						2133MHz da Kingston e placa mãe Asus Z170M-PLUS/BR</div>
					<div class="col-sm-4 right">- R$ 400,00</div>
				</div>
				<div class="row desconto">
					<div class="col-sm-8">Desconto: SSD Kingston de 120GB</div>
					<div class="col-sm-4 right">- R$ 2.790,00</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-sm-8">Total à pagar</div>
					<div class="col-sm-4 right">R$ 10.510,00</div>
				</div>
			</div>
			<div id="buttons" class="row right">
				<button class="btn btn-primary">Cancelar</button>
				<button class="btn btn-primary">Finalizar</button>
			</div>
		</div>
	</div>
</body>
</html>