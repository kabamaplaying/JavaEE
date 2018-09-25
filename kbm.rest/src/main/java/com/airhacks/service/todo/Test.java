package com.airhacks.service.todo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.airhacks.model.Todo;

public class Test {
 public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("kbm.rest");
	EntityManager em = emf.createEntityManager();
	


	
	Todo to = new Todo();
	to.setDatecompleted("2018/02/03");
	to.setIscompleted(false);
	to.setDatecreated("2018/09/03");
	to.setDuedate("2018/05/03");
	to.setTask("Nueva Tarea 15");
	em.getTransaction().begin();
	em.persist(to);
	em.getTransaction().commit();
	
	TypedQuery<Todo> qo = em.createQuery("SELECT t FROM Todo t", Todo.class);
	List<Todo> test = qo.getResultList();
	
	test.stream().forEach(e -> System.out.println(e.getTask()));
}
}
