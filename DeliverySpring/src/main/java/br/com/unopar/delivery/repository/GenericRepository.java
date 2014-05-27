package br.com.unopar.delivery.repository;


public interface GenericRepository<T> {
	
	public abstract void adicionarOuAtualizar(T entity);
	
	public abstract void excluir(T entity);
	
	public abstract T buscar(Object id);
}
