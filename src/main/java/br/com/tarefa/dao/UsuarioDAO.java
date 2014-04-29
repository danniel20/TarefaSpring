package br.com.tarefa.dao;

import br.com.tarefa.modelo.Usuario;

public interface UsuarioDAO {

    public boolean existeUsuario(Usuario usuario);

    public void salvar(Usuario usuario);
}
