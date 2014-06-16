<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
											"sLengthMenu" : "Mostrar _MENU_ registros por página",
											"sLoadingRecords" : "Carregando...",
											"sProcessing" : "Processando...",
											"sZeroRecords" : "Nenhum registro encontrado",
											"sSearch" : "Pesquisar",
											"oPaginate" : {
												"sNext" : "Próximo",
												"sPrevious" : "Anterior",
												"sFirst" : "Primeiro",
												"sLast" : "Último"
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
	<fmt:setLocale value="pt_BR"/>
	<div id="conteudo" style="width: 1000px; margin: 0 auto;">
		
		<jsp:include page="../fragments/headerCliente.jsp" />
		
		<div style="text-align: center;">
			<label class="control-label" style="font-size: 20px;">Pedido ${pedido.id} - ${pedido.estabelecimento.nome} - ${pedido.status}</label>
		</div>
		
		<datatables:table id="pedido" data="${pedido.pp}" cdn="true" row="pp" theme="bootstrap2" cssClass="table table-striped">
			<datatables:column title="Produto">
				<c:out value="${pp.produto.nome}"></c:out>
			</datatables:column>

			<datatables:column title="Categoria">
				<c:out value="${pp.produto.categoria}"></c:out>
			</datatables:column>
			
			<datatables:column title="Preço Unitário">
				<fmt:formatNumber value="${pp.produto.preco}" type="currency"/>
			</datatables:column>

			<datatables:column title="Quantidade">
				<c:out value="${pp.quantidade}"></c:out>
			</datatables:column>
			
			<datatables:column title="Preço total">
				<fmt:formatNumber value="${pp.produto.preco * pp.quantidade}" type="currency"/>
			</datatables:column>

		</datatables:table>
		
		<div style="margin-top: 60px; text-align: right;">
			<label style="font-size: 20px;">Total: <fmt:formatNumber value="${pedido.valor}" type="currency"/></label>
		</div>
		
		<jsp:include page="../fragments/footer.jsp" />
		
	</div>
</body>
</html>