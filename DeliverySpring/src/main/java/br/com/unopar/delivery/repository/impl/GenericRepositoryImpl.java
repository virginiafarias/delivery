package br.com.unopar.delivery.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.unopar.delivery.repository.GenericRepository;

public class GenericRepositoryImpl<T> implements GenericRepository<T>{

	@PersistenceContext
    protected EntityManager em;
	
	protected Class<T> persistentClass;
	
	@Transactional
	public T adicionarOuAtualizar(T entity) {
		return this.em.merge(entity);		
	}

	@Transactional
	public void excluir(T entity) {
		em.remove(em.merge(entity));		
	}

	public T buscar(Object id) {
		return em.find(this.persistentClass, id);
	}

}
