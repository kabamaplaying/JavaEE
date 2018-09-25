package com.airhacks.service.todo;

import java.util.List;
import java.util.logging.Level;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.airhacks.model.Todo;


@Stateless
public class TodoService {

	@PersistenceContext(unitName ="kbm.rest", type = PersistenceContextType.TRANSACTION)
	EntityManager em;
	
	/**
	 * Registramos un nuevo Todo
	 * 
	 * */
	public void save(Todo todo) {
		em.persist(todo);
	}
	/**
	 * carga el listado de Todos
	 * */
	public List<Todo> all(){
		TypedQuery<Todo> qo = em.createQuery("SELECT t FROM Todo t", Todo.class);
		return qo.getResultList();
	}
}
