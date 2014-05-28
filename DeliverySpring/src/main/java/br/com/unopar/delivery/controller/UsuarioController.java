package br.com.unopar.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.unopar.delivery.service.ClienteService;

@Controller
public class UsuarioController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("email") String senha, SessionStatus session) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	

}
