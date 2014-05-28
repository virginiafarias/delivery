<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Cliente</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../fragments/headTag.jsp" />
</head>
<body>
	<div id="conteudo" style="width: 1000px; margin: 0 auto;">
		<div class="page-header">
		  <h1>Delivery <small>Sistema de pedidos</small></h1>
		</div>
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
			      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="<c:url value='/'/>">Home</a>
			    </div>
			</div>
		</nav>

		<form:form id="cliente" class="form-horizontal" role="form" action="/delivery/cliente/cadastrar" method="post" modelAttribute="cliente">
		  
		  <h3>Dados pessoais</h3>
		  <div class="form-group">
		    <label for="nome" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="nome" placeholder="Nome" path="nome"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="email" class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="email" placeholder="Email" path="email"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="telefone" class="col-sm-2 control-label">Telefone</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="telefone" placeholder="Telefone" path="telefone"/>
		    </div>
		  </div>
		  
		  <h3>Login</h3>
		  <div class="form-group">
		    <label for="login" class="col-sm-2 control-label">Login</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="login" placeholder="Login" path="usuario.login"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="senha" class="col-sm-2 control-label">Senha</label>
		    <div class="col-sm-10">
		      <form:input type="password" class="form-control" id="senha" placeholder="Senha" path="usuario.senha"/>
		    </div>
		  </div>
		  
		  <h3>Endereço</h3>
		  <div class="form-group">
		    <label for="rua" class="col-sm-2 control-label">Rua</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="rua" placeholder="Rua" path="endereco.rua"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="numero" class="col-sm-2 control-label">Número</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="numero" placeholder="Número" path="endereco.numero"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="bairro" class="col-sm-2 control-label">Bairro</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="bairro" placeholder="Bairro" path="endereco.bairro"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="cidade" class="col-sm-2 control-label">Cidade</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="cidade" placeholder="Cidade" path="endereco.cidade"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="estado" class="col-sm-2 control-label">Estado</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="estado" placeholder="Estado" path="endereco.estado"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-info">Cadastrar</button>
		    </div>
		  </div>
		</form:form>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>
</html>