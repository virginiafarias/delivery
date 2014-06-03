<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
	<title>Pedidos</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="../fragments/headTag.jsp" />
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$.fn.dataTableExt.sErrMode = 'throw';
							$('#pedidos').dataTable(
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
	
						});
	</script>
</head>
<body>
	<div id="conteudo" style="width: 1000px; margin: 0 auto;">
		
		<jsp:include page="../fragments/header.jsp" />
		
		<div style="text-align: center;">
			<label class="control-label" style="font-size: 20px;">Pedidos</label>
		</div>

		<datatables:table id="pedidos" data="${cliente.pedidos}" cdn="true" row="pedido" theme="bootstrap2" cssClass="table table-striped">
			<datatables:column title="ID">
				<c:out value="${pedido.id}"></c:out>
			</datatables:column>

			<datatables:column title="Data">
				<c:out value="${pedido.data}"></c:out>
			</datatables:column>
			
			<datatables:column title="Preço">
				<c:out value="${pedido.status}"></c:out>
			</datatables:column>

			<datatables:column title="Editar">
				<a class="buttonAdd" href="<c:url value = "/pedido/${pedido.id}/editar.htm"></c:url>">Editar</a>
			</datatables:column>

			<datatables:column title="Excluir">
				<a class="buttonAdd" href="<c:url value = "/pedido/${pedido.id}//excluir.htm"></c:url>">Excluir</a>
			</datatables:column>
		</datatables:table>
		
		<jsp:include page="../fragments/footer.jsp" />
		
	</div>
</body>
</html>