<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<title>Delivery</title>

<jsp:include page="fragments/headTag.jsp" />
<link href="<c:url value="/resources/css/npi.css" />" rel="stylesheet" />

<body>
	<div class="container">
		<div class="page-header">
		  <a type="button" class="cadastrar btn btn-danger" href="<c:url value="/estabelecimento/cadastrar" />">Adicionar estabelecimento</a>
		  <a type="button" class="cadastrar btn btn-danger" href="<c:url value="/cliente/cadastrar" />">Cadastrar</a>
		  <h1>Delivery <small>Sistema de pedidos</small></h1>
		</div>

		<div id="conteudo" style="text-align: center; margin-top: 50px;">

			<div id="login" style="width: 300px; margin: 0 auto;">
				<c:if test="${not empty error}">
					<div class="alert alert-danger alert-dismissable">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<c:out value="${error }"></c:out>
					</div>
				</c:if>

				<form action="/delivery/login" id="login-form" method="POST" >
					<div class="form-group">
						<label class="col-sm-2 control-label">Login:</label> <input
							type="text" name="login" class="form-control" />
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Senha:</label> <input
							type="password" name="senha" class="form-control" />
					</div>

					<input type="submit" class="btn btn-info" value="Entrar"/>

				</form>
			</div>

			<div style="margin-top: 100px;">
				<jsp:include page="fragments/footer.jsp" />
			</div>

		</div>


	</div>
</body>

</html>