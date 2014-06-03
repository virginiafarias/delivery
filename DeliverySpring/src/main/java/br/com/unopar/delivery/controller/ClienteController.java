package br.com.unopar.delivery.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.unopar.delivery.model.Cliente;
import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.model.Pedido;
import br.com.unopar.delivery.model.PedidoProduto;
import br.com.unopar.delivery.model.Produto;
import br.com.unopar.delivery.service.ClienteService;
import br.com.unopar.delivery.service.EstabelecimentoService;
import br.com.unopar.delivery.service.PedidoService;
import br.com.unopar.delivery.service.ProdutoService;

@Controller
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String cadastro(ModelMap modelMap) {
		modelMap.addAttribute("cliente", new Cliente());
		return "cliente/cadastro";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastro(@Valid Cliente cliente, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			return "cliente/cadastro";
		}
		clienteService.cadastrar(cliente);
		return "redirect:/";
	}
	
	@RequestMapping(value="/buscarEstabelecimento", method=RequestMethod.GET)
	public String buscarEstabelecimento(@RequestParam("estabelecimento") Integer id, ModelMap modelMap, HttpSession session) {
		Estabelecimento estabelecimento = estabelecimentoService.getById(id);
		
		Pedido pedido = new Pedido();
		pedido.setCliente((Cliente) session.getAttribute("usuario"));
		pedido.setEstabelecimento(estabelecimento);
		pedido.setValor(0.0);
		
		session.setAttribute("pedido", pedido);
		session.setAttribute("estabelecimento", estabelecimento);
		session.setAttribute("pedidoProduto", new ArrayList<PedidoProduto>());
		
		modelMap.addAttribute("estabelecimento", estabelecimento);
		modelMap.addAttribute("pedidoProduto", new ArrayList<PedidoProduto>());
		
		return "cliente/realizarPedido";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/adicionarProduto", method=RequestMethod.GET)
	public String adicionarProduto(@RequestParam("quantidade") Integer quantidade, @RequestParam("id") Integer id, ModelMap modelMap, HttpSession session) {
		Produto produto = produtoService.getById(id);
		List<PedidoProduto> ppList = (List<PedidoProduto>) session.getAttribute("pedidoProduto");
		
		PedidoProduto pp = new PedidoProduto();
		//pp.setPedido((Pedido) session.getAttribute("pedido"));
		pp.setProduto(produto);
		pp.setQuantidade(quantidade);
		
		ppList.add(pp);
		
		session.removeAttribute("pedidoProduto");
		session.setAttribute("pedidoProduto", ppList);
		
		modelMap.addAttribute("pedidoProduto", ppList);
		
		return "cliente/realizarPedido";
	}
	
	@RequestMapping(value="/finalizarPedido", method=RequestMethod.GET)
	public String finalizarPedido(@RequestParam("total") Double total, HttpSession session) {
		Pedido pedido = (Pedido) session.getAttribute("pedido");
		pedido.setValor(total);
		pedido.setData(new Date());
		
		pedido = pedidoService.cadastrar(pedido);
		
		List<PedidoProduto> ppList = (List<PedidoProduto>) session.getAttribute("pedidoProduto");
		
		for (PedidoProduto pp : ppList) {
			pp.setPedido(pedido);
			pedidoService.cadastrar(pp);
		}
		
		return "redirect:/cliente/pedidos";
	}
	
	@RequestMapping(value="/pedidos", method=RequestMethod.GET)
	public String pedidos(ModelMap modelMap, HttpSession session) {
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		cliente = clienteService.getById(cliente.getId());
		modelMap.addAttribute("cliente", cliente);
		return "cliente/pedidos";
	}

}
