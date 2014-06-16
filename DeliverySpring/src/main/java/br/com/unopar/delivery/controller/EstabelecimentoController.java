package br.com.unopar.delivery.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.model.Pedido;
import br.com.unopar.delivery.model.Produto;
import br.com.unopar.delivery.service.EstabelecimentoService;
import br.com.unopar.delivery.service.PedidoService;
import br.com.unopar.delivery.service.ProdutoService;
import br.com.unopar.delivery.util.Status;

@Controller
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String cadastro(ModelMap modelMap) {
		modelMap.addAttribute("estabelecimento", new Estabelecimento());
		return "estabelecimento/cadastro";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastro(@Valid Estabelecimento estabelecimento, BindingResult result, ModelMap modelMap, HttpSession session) {
		if (result.hasErrors()) {
			return "estabelecimento/cadastro";
		}
		Estabelecimento est = estabelecimentoService.cadastrar(estabelecimento);
		session.setAttribute("usuario", est);
		return "redirect:/estabelecimento/produtos";
	}
	
	@RequestMapping(value="/pedidos", method=RequestMethod.GET)
	public String pedidos(ModelMap modelMap, HttpSession session) {
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("usuario");
		estabelecimento = estabelecimentoService.getById(estabelecimento.getId());
		modelMap.addAttribute("estabelecimento", estabelecimento);
		return "estabelecimento/pedidos";
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public String produtos(ModelMap modelMap, HttpSession session) {
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("usuario");
		estabelecimento = estabelecimentoService.getById(estabelecimento.getId());
		modelMap.addAttribute("estabelecimento", estabelecimento);
		return "estabelecimento/produtos";
	}
	
	@RequestMapping(value="/adicionarProduto", method=RequestMethod.GET)
	public String adicionarProdutosForm(ModelMap modelMap, HttpSession session) {
		modelMap.addAttribute("produto", new Produto());
		return "estabelecimento/produto";
	}
	
	@RequestMapping(value="/adicionarProduto", method=RequestMethod.POST)
	public String adicionarProduto(@Valid Produto produto, BindingResult result, ModelMap modelMap, HttpSession session) {
		if (result.hasErrors()) {
			return "estabelecimento/produto";
		}
		Estabelecimento estabelecimento = (Estabelecimento) session.getAttribute("usuario");
		produto.setEstabelecimento(estabelecimento);
		produto = produtoService.cadastrar(produto);
		if (estabelecimento.getProdutos() == null) {
			estabelecimento.setProdutos(new ArrayList<Produto>());
		}
		estabelecimento.getProdutos().add(produto);
		estabelecimento = estabelecimentoService.cadastrar(estabelecimento);
		session.removeAttribute("usuario");
		session.setAttribute("usuario", estabelecimento);
		return "redirect:/estabelecimento/produtos";
	}
	
	@RequestMapping(value="/detalhePedido/{id}", method=RequestMethod.GET)
	public String detalhePedido(@PathVariable("id") Integer id, ModelMap modelMap, HttpSession session) {
		Pedido pedido = pedidoService.getById(id);
		modelMap.addAttribute("pedido", pedido);
		return "estabelecimento/detalhePedido";
	}
	
	@RequestMapping(value="/atenderPedido/{id}", method=RequestMethod.GET)
	public String atenderPedido(@PathVariable("id") Integer id, ModelMap modelMap, HttpSession session) {
		Pedido pedido = pedidoService.getById(id);
		pedido.setStatus(Status.ATENDIDO);
		pedido = pedidoService.cadastrar(pedido);
		modelMap.addAttribute("pedido", pedido);
		return "estabelecimento/detalhePedido";
	}
	
	@RequestMapping(value="/finalizarPedido/{id}", method=RequestMethod.GET)
	public String finalizarPedido(@PathVariable("id") Integer id, ModelMap modelMap, HttpSession session) {
		Pedido pedido = pedidoService.getById(id);
		pedido.setStatus(Status.FINALIZADO);
		pedido = pedidoService.cadastrar(pedido);
		modelMap.addAttribute("pedido", pedido);
		return "estabelecimento/detalhePedido";
	}

}
