package br.com.unopar.delivery.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.model.Produto;
import br.com.unopar.delivery.service.EstabelecimentoService;
import br.com.unopar.delivery.service.ProdutoService;

@Controller
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private ProdutoService produtoService;
	
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
		return "redirect:/estabelecimento/pedidos";
	}
	
	@RequestMapping(value="/pedidos", method=RequestMethod.GET)
	public String pedidos(ModelMap modelMap, HttpSession session) {
		modelMap.addAttribute("estabelecimento", session.getAttribute("usuario"));
		return "estabelecimento/pedidos";
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
		session.removeAttribute("usuario");
		session.setAttribute("usuario", estabelecimento);
		modelMap.addAttribute("produto", new Produto());
		return "estabelecimento/produtos";
	}

}
