package br.com.tarefa.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tarefa.modelo.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@PersistenceContext
	protected EntityManager entityManager;

	public boolean existeUsuario(Usuario usuario) {
		
		Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.login= :login AND u.senha= :senha");
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		
		try{
			return query.getSingleResult() != null;
		}
		catch(NoResultException nre){
			return false;
		}
	}

	@Transactional
	public void salvar(Usuario usuario) {
		entityManager.persist(usuario);
	}
}
