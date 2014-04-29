package br.com.tarefa.dao;

import javax.persistence.*;
import java.util.*;

import br.com.tarefa.modelo.Tarefa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TarefaDAOImpl implements TarefaDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    public void salvar(Tarefa tarefa) {
        entityManager.persist(tarefa);
    }

    public List<Tarefa> listarTodas() {
        TypedQuery<Tarefa> query = entityManager.createQuery("SELECT t FROM Tarefa t", Tarefa.class);
        return query.getResultList();
    }

    @Transactional
    public void deletar(Tarefa tarefa) {
        Tarefa t = entityManager.merge(tarefa);
        entityManager.remove(t);
    }

    public Tarefa buscarPorId(Long id) {
        return entityManager.find(Tarefa.class, id);
    }

    @Transactional
    public void atualizar(Tarefa tarefa) {
        entityManager.merge(tarefa);
    }

    @Transactional
    public void finaliza(Long id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        Calendar calendar = Calendar.getInstance();
        tarefa.setDataFinalizacao(calendar);
        tarefa.getDataFinalizacao().setTime(new Date());
        tarefa.setFinalizado(true);
        entityManager.merge(tarefa);
    }

}
