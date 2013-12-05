package br.com.tarefa.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefa.dao.UsuarioDAO;
import br.com.tarefa.modelo.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	
	@RequestMapping(value="efetuaLogin")
	public String efetuaLogin(@Valid Usuario usuario, BindingResult result, HttpSession session){
		
		if(result.hasErrors()){
			return "formulario-login";
		}
		
		if(usuarioDAO.existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		
		return "redirect:loginForm";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";
	}
	
	@RequestMapping(value="cadastrarUsuarioTeste")
	public void cadastrarUsuarioTeste(){
		
		Usuario usuarioTeste = new Usuario();
		usuarioTeste.setLogin("teste");
		usuarioTeste.setSenha("teste");
		
		usuarioDAO.salvar(usuarioTeste);
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
