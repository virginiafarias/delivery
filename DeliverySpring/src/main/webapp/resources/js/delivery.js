

function addPedido(id) {
	var quantidade = $('#qt' + id).val();
	
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/delivery/cliente/" + id + "/adicionarProduto",
		data : { quantidade: quantidade},
	
	});
	
}