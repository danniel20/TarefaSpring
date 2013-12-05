package br.com.tarefa.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarefa.modelo.Tarefa;

@Repository
public class TarefaDAOImpl implements TarefaDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public void salvar(Tarefa tarefa){
		entityManager.persist(tarefa);
	}
	
	public List<Tarefa> listarTodas(){
		
		Query query = entityManager.createQuery("SELECT t FROM Tarefa t");
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
