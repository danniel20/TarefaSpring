package br.com.tarefa.dao;

import java.util.List;

import br.com.tarefa.modelo.Tarefa;

public interface TarefaDAO {

    public void salvar(Tarefa tarefa);

    public List<Tarefa> listarTodas();

    public void deletar(Tarefa tarefa);

    public Tarefa buscarPorId(Long id);

    public void atualizar(Tarefa tarefa);

    public void finaliza(Long id);
}