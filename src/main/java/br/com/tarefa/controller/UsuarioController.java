package br.com.tarefa.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import br.com.tarefa.dao.UsuarioDAO;
import br.com.tarefa.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping(value = "novoUsuario")
    public String form() {
        return "usuario/formulario";
    }

    @RequestMapping(value = "cadastraUsuario")
    public String cadastraUsuario(@Valid Usuario usuario, BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) {
            return "usuario/formulario";
        }

        if (usuarioDAO.existeUsuario(usuario)) {
            String msg = "Usuário já existe!";
            model.addAttribute("mensagem", msg);
            return "usuario/formulario";
        }

        usuarioDAO.salvar(usuario);
        session.setAttribute("usuarioLogado", usuario);
        return "menu";
    }
}
