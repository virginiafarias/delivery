package br.com.unopar.delivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.service.EstabelecimentoService;

@Controller
@RequestMapping("estabelecimento")
public class EstabelecimentoController {
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public String cadastro(ModelMap modelMap) {
		modelMap.addAttribute("estabelecimento", new Estabelecimento());
		return "estabelecimento/cadastro";
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public String cadastro(@Valid Estabelecimento estabelecimento, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			return "estabelecimento/cadastro";
		}
		estabelecimentoService.cadastrar(estabelecimento);
		return "redirect:/";
	}

}
