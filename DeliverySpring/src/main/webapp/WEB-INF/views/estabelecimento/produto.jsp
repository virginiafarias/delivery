<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="datatables"
	uri="http://github.com/dandelion/datatables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>Cadastro Produto</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../fragments/headTag.jsp" />
<script type="text/javascript">
	$(document) .ready( function() {
		$('#preco').mask("11/11/1111");
	});
</script>
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

		<form:form id="produto" class="form-horizontal" role="form" action="/delivery/estabelecimento/adicionarProduto" method="post" modelAttribute="produto">
		  
		  <h3>Adicionar produto</h3>
		  <div class="form-group">
		    <label for="nome" class="col-sm-2 control-label">Nome</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="nome" placeholder="Nome" path="nome"/>
		      <form:errors path="nome"></form:errors>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="preco" class="col-sm-2 control-label">Preço</label>
		    <div class="col-sm-10">
		      <form:input type="text" class="form-control" id="preco" placeholder="Preço" path="preco" />
		      <form:errors path="preco"></form:errors>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="telefone" class="col-sm-2 control-label">Categoria</label>
		    <div class="col-sm-10">
		    	<form:select path="categoria" class="form-control">
		    		<form:option value="BEBIDA">Bebida</form:option>
		    		<form:option value="SALGADO">Salgado</form:option>
		    		<form:option value="PORÇÃO">Porção</form:option>
		    		<form:option value="CARNE">Carne</form:option>
		    		<form:option value="DOCE">Doce</form:option>
		    		<form:option value="PETISCO">Petisco</form:option>
		    	</form:select>
		      <form:errors path="categoria"></form:errors>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-info">Adicionar</button>
		    </div>
		  </div>
		</form:form>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>
</html>