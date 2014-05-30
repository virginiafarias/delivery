package br.com.unopar.delivery.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.unopar.delivery.model.Estabelecimento;
import br.com.unopar.delivery.model.Usuario;
import br.com.unopar.delivery.service.EstabelecimentoService;
import br.com.unopar.delivery.service.UsuarioService;
import br.com.unopar.delivery.util.Role;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("login") String login, @RequestParam("senha") String senha, HttpSession session, ModelMap map) {
		if (login == null || login.isEmpty() || senha == null || senha.isEmpty()) {
			map.addAttribute("error", "Preencha todos os campos");
			return "welcome";
		}
		List<Usuario> usuarios = usuarioService.getUsuarioByLogin(login, senha);
		if (usuarios == null || usuarios.isEmpty()) {
			map.addAttribute("error", "login ou senha inválidos");
			return "welcome";
		}
		
		Usuario usuario = usuarios.get(0);
		if (usuario.getRole().equals(Role.CLIENTE)) {
			// Cliente: mostra a tela de busca
			return "cliente/busca";
			
		} else {
			Estabelecimento estabelecimento = estabelecimentoService.getByUsuarioId(usuario.getId());
			map.addAttribute("estabelecimento", estabelecimento);
			return "estabelecimento/pedidos";
		}
		
	}
	
	

}
