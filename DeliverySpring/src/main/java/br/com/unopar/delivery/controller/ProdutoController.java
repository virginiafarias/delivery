package br.com.unopar.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unopar.delivery.model.Produto;
import br.com.unopar.delivery.service.ProdutoService;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable("id") Integer id, ModelMap modelMap) {
		Produto produto = produtoService.getById(id);
		modelMap.addAttribute("produto", produto);
		return "estabelecimento/produto";
	}
	
	@RequestMapping(value="/excluir/{id}", method=RequestMethod.GET)
	public String excluir(@PathVariable("id") Integer id, ModelMap modelMap) {
		produtoService.excluir(id);
		return "redirect:/estabelecimento/produtos";
	}
	

}
