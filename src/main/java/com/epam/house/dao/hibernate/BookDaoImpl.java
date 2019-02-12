package com.epam.house.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.epam.house.dao.IDaoBook;
import com.epam.house.entity.Book;
import com.epam.house.util.HibernateUtil;


public class BookDaoImpl implements IDaoBook
{
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Integer save(final Book book)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return book.getId();
	}

	public void update(final Book book)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.update(book);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void remove(final Book book)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.remove(book);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public Book getById(final Integer id)
	{
		Book book = null;
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			book = session.get(Book.class, id);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return book;
	}

	public List<Book> getAll()
	{

		List <Book> result = null;
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("select b from Book as b");
			result = query.list();
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return result;
	}
}
