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

		<form id="busca" class="form-horizontal" action="/delivery/cliente/buscarEstabelecimento" method="get">
			<div class="form-group">
				<div class="col-sm-10">
					<select class="form-group" name="estabelecimento">
						<c:forEach items="${estabelecimentos}" var="estabelecimento">
							<option value="${estabelecimento.id }">${estabelecimento.nome} </option>
						</c:forEach>
					</select>
				</div>
			</div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-info">Buscar</button>
		    </div>
		  </div>
		</form>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>
</html>