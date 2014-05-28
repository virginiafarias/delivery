package br.com.unopar.delivery.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unopar.delivery.model.Cliente;
import br.com.unopar.delivery.service.ClienteService;

@Controller
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
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

}
