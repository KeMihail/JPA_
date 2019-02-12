package com.epam.house.dao.hibernate.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.epam.house.dao.IDaoPassword;
import com.epam.house.entity.Password;
import com.epam.house.util.HibernateUtil;


public class PasswordDaoImpl implements IDaoPassword
{
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Integer save(final Password password)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.save(password);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return password.getId();
	}

	public void update(final Password password)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.update(password);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void remove(final Password password)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.remove(password);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public Password getById(final Integer id)
	{

		Password password = null;

		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("select p from Password as p where p.id =:id");
			query.setParameter("id", id);
			password = (Password) query.list().get(0);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return password;
	}

	public List<Password> getAll()
	{
		List<Password> result = null;
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("select p from Password as p");
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
