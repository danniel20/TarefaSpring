package br.com.tarefa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefa.dao.TarefaDAO;
import br.com.tarefa.modelo.Tarefa;

@Controller
public class TarefasController {
	
	@Autowired
	private TarefaDAO tarefaDAO;
	
	@RequestMapping(value="novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	@RequestMapping(value="adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		
		if(result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		
		tarefaDAO.salvar(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping(value="listaTarefas")
	public String lista(Model model){
		
		List<Tarefa> tarefas = tarefaDAO.listarTodas();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
	}
	
	@RequestMapping(value="removeTarefa")
	public String remover(Tarefa tarefa){
		
		tarefaDAO.deletar(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping(value="mostraTarefa")
	public String mostra(Long id, Model model){
		model.addAttribute("tarefa", tarefaDAO.buscarPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping(value="alteraTarefa")
	public String altera(Tarefa tarefa){
		tarefaDAO.atualizar(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping(value="finalizada")
	public String finaliza(Long id, Model model){
		tarefaDAO.finaliza(id);
		model.addAttribute("tarefa", tarefaDAO.buscarPorId(id));
		return "tarefa/finalizada";
	}
	
	public void setTarefaDAO(TarefaDAO tarefaDAO) {
		this.tarefaDAO = tarefaDAO;
	}
}
