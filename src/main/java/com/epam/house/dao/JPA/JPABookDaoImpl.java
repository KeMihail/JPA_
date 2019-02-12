package com.epam.house.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.house.dao.IDaoBook;
import com.epam.house.entity.Book;


public class JPABookDaoImpl implements IDaoBook
{
	private EntityManager entityManager = Persistence.createEntityManagerFactory("house").createEntityManager();

	public Integer save(final Book book)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();

		return book.getId();
	}

	public void update(final Book book)
	{
		entityManager.getTransaction().begin();
		entityManager.merge(book);
		entityManager.getTransaction().commit();
	}

	public void remove(final Book book)
	{
		if (getById(book.getId()) != null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(book);
			entityManager.getTransaction().commit();
		}
	}

	public Book getById(final Integer id)
	{
		return entityManager.find(Book.class, id);
	}

	public List<Book> getAll()
	{
		TypedQuery<Book> query = entityManager.createNamedQuery("book.getAll", Book.class);
		return query.getResultList();
	}
}
