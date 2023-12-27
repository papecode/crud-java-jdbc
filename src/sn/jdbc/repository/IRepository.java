package sn.jdbc.repository;

import java.util.List;

import sn.jdbc.exceptions.RepositoryException;

/**
 * @param <T>
 */
public interface IRepository<T> {
	
	/**
	 * @param entity
	 * @throws RepositoryException
	 */
	public void create (T entity) throws RepositoryException;
	
	/**
	 * @param id
	 * @return
	 * @throws RepositoryException
	 */
	public T read (int id) throws RepositoryException;
	
	/**
	 * @return
	 * @throws RepositoryException
	 */
	public List<T> list () throws RepositoryException;
	
	/**
	 * @param entity
	 * @throws RepositoryException
	 */
	public void update (T entity) throws RepositoryException;
	
	/**
	 * @param id
	 * @throws RepositoryException
	 */
	public void delete (int id) throws RepositoryException;
}
