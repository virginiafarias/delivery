package br.com.unopar.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unopar.delivery.service.ProdutoService;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/listar.htm", method = RequestMethod.GET)
	public String listar(ModelMap modelMap) {
		
		modelMap.addAttribute("produtos", this.produtoService.listar());
		return "estabelecimento/produtos";
		
	}

}
