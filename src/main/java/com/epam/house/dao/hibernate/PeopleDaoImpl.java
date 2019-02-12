package com.epam.house.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.epam.house.dao.IDaoPeople;
import com.epam.house.entity.People;
import com.epam.house.util.HibernateUtil;


public class PeopleDaoImpl implements IDaoPeople
{
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Integer save(final People people)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.save(people);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return people.getId();
	}

	public void update(final People people)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.update(people);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	public void remove(final People people)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.remove(people);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public People getById(final Integer id)
	{
		People people = null;
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			people = session.get(People.class,id);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return people;
	}

	public List<People> getAll()
	{
		List <People> result = null;
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("select p from People as p");
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
