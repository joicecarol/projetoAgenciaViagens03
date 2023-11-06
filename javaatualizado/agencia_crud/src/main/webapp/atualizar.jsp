<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="./icon/favicon.ico">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Update</title>
</head>
<body>
    <!-- Cabeçalho -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark custom-navbar text-light">
            <div class="container">
                <a class="navbar-brand" href="#"><img src="img/Logo Serviços De Turismo (3).png" height="48px"/></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#cadastros">Cadastros</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#sobre">Sobre</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contato">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
    <h2 class="mt-2">Atualizar Cliente</h2>
    <form class="mt-1 mb-2" action="UpdateController" method="post">
        <div class="form-group">
            <label for="nome">ID:</label>
            <input type="text" class="form-control form-control-sm" id="idCliente" name="idCliente" value="${cliente.idCliente}" readonly>
        </div>
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control form-control-sm" id="nome" name="nome" value="${cliente.nome}" required>
        </div>
					<div class="form-group">
            <label for="telefone">Telefone:</label>
            <input type="text" class="form-control form-control-sm" id="telefone" name="telefone" value="${cliente.telefone}" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control form-control-sm" id="email" name="email" value="${cliente.email}" required>
        </div>
					<div class="form-group">
            <label for="metododePagamento">Método de Pagamento:</label>
            <input type="text" class="form-control form-control-sm" id="metododePagamento" name="metododePagamento" value="${cliente.metododePagamento}" required>
     
       <button type="submit" class="btn btn-primary btn-sm">Atualizar</button>
        </div>
        
        
    </form>
</div>
		</div>
	</div>
	 <!-- Rodapé -->
    <footer class="custom-footer text-light text-center py-3 fixed-bottom">
        &copy; 2023 Sua Empresa. Todos os direitos reservados.
    </footer>


	<!-- Inclua os scripts do Bootstrap via CDN -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>