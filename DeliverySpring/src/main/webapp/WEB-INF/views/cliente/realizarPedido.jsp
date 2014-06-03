<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
	<title>Realizar pedido</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="../fragments/headTag.jsp" />
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$.fn.dataTableExt.sErrMode = 'throw';
							$('#produto').dataTable(
								{
									"sPaginationType" : "full_numbers",
									"oLanguage" : {
										"sEmptyTable" : "Nenhum registro encontrado na tabela",
										"sInfo" : "Mostrar _START_ até _END_ do _TOTAL_ registros",
										"sInfoEmpty" : "Mostrar 0 até 0 de 0 Registros",
										"sInfoFiltered" : "(Filtrar de _MAX_ total registros)",
										"sInfoPostFix" : "",
										"sInfoThousands" : ".",
										"sLengthMenu" : "Mostrar _MENU_ registros por pagina",
										"sLoadingRecords" : "Carregando...",
										"sProcessing" : "Processando...",
										"sZeroRecords" : "Nenhum registro encontrado",
										"sSearch" : "Pesquisar",
										"oPaginate" : {
											"sNext" : "Proximo",
											"sPrevious" : "Anterior",
											"sFirst" : "Primeiro",
											"sLast" : "Ultimo"
										},
										"oAria" : {
											"sSortAscending" : ": Ordenar colunas de forma ascendente",
											"sSortDescending" : ": Ordenar colunas de forma descendente"
										}
									}
								}
							);
							$('#pedido').dataTable(
									{
										"sPaginationType" : "full_numbers",
										"oLanguage" : {
											"sEmptyTable" : "Nenhum registro encontrado na tabela",
											"sInfo" : "Mostrar _START_ até _END_ do _TOTAL_ registros",
											"sInfoEmpty" : "Mostrar 0 até 0 de 0 Registros",
											"sInfoFiltered" : "(Filtrar de _MAX_ total registros)",
											"sInfoPostFix" : "",
											"sInfoThousands" : ".",
											"sLengthMenu" : "Mostrar _MENU_ registros por pagina",
											"sLoadingRecords" : "Carregando...",
											"sProcessing" : "Processando...",
											"sZeroRecords" : "Nenhum registro encontrado",
											"sSearch" : "Pesquisar",
											"oPaginate" : {
												"sNext" : "Proximo",
												"sPrevious" : "Anterior",
												"sFirst" : "Primeiro",
												"sLast" : "Ultimo"
											},
											"oAria" : {
												"sSortAscending" : ": Ordenar colunas de forma ascendente",
												"sSortDescending" : ": Ordenar colunas de forma descendente"
											}
										}
									}
								);
							
							$('.addProduto').submit(function() {
								$(this).find('input[name="quantidade"]').val($('#qt'+ $(this).find('input[name="id"]').val()).val());
							});
	
						});
	</script>
</head>
<body>
	<div id="conteudo" style="width: 1000px; margin: 0 auto;">
		
		<jsp:include page="../fragments/header.jsp" />
		
		<div style="text-align: center;">
			<label class="control-label" style="font-size: 20px;">Produtos</label>
		</div>

		<datatables:table id="produto" data="${estabelecimento.produtos}" cdn="true" row="produto" theme="bootstrap2" cssClass="table table-striped">
			<datatables:column title="Nome">
				<c:out value="${produto.nome}"></c:out>
			</datatables:column>

			<datatables:column title="Categoria">
				<c:out value="${produto.categoria}"></c:out>
			</datatables:column>
			
			<datatables:column title="Preço">
				<c:out value="${produto.preco}"></c:out>
			</datatables:column>

			<datatables:column title="Quantidade">
				<input id="qt${produto.id}" type="text" name="quantidade"/>
			</datatables:column>

			<datatables:column title="Adicionar ao pedido">
				<form class="addProduto" action="<c:url value = "/cliente/adicionarProduto"></c:url>">
					<input type="hidden" name="quantidade" value=""/>
					<input type="hidden" name="id" value="${produto.id}"/>
					<button type="submit" class="btn btn-info">Adicionar</button>
				</form>
			</datatables:column>
		</datatables:table>
		
		<div style="text-align: center; margin-top: 80px;">
			<label class="control-label" style="font-size: 20px;">Seu pedido</label>
		</div>
		
		<c:set var="total" value="0.0"></c:set>
		
		<datatables:table id="pedido" data="${pedidoProduto}" cdn="true" row="pp" theme="bootstrap2" cssClass="table table-striped">
			<datatables:column title="Produto">
				<c:out value="${pp.produto.nome}"></c:out>
			</datatables:column>

			<datatables:column title="Categoria">
				<c:out value="${pp.produto.categoria}"></c:out>
			</datatables:column>
			
			<datatables:column title="Preço Unitário">
				<c:out value="${pp.produto.preco}"></c:out>
			</datatables:column>

			<datatables:column title="Quantidade">
				<c:out value="${pp.quantidade}"></c:out>
			</datatables:column>
			
			<datatables:column title="Preço total">
				<c:out value="${pp.produto.preco * pp.quantidade}"></c:out>
				<c:set var="total" value="${total + (pp.produto.preco * pp.quantidade)}"></c:set>
			</datatables:column>

			<datatables:column title="Excluir">
				<a class="buttonAdd" href="">Excluir</a>
			</datatables:column>
		</datatables:table>
		
		<div style="margin-top: 60px; text-align: right;">
			<label style="font-size: 20px;">Total: <c:out value="${total}"></c:out></label>
		</div>
		
		<div style="text-align: right;">
			<form id="finalizarPedido" action="<c:url value = "/cliente/finalizarPedido"></c:url>">
				<input type="hidden" name="total" value="${total}"/>
				<button type="submit" class="btn btn-info">Finalizar</button>
			</form>
		</div>
		
		<jsp:include page="../fragments/footer.jsp" />
		
	</div>
</body>
</html>