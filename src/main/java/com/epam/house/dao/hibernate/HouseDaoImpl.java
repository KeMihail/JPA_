package com.epam.house.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.epam.house.dao.IDaoHouse;
import com.epam.house.entity.House;
import com.epam.house.util.HibernateUtil;


public class HouseDaoImpl implements IDaoHouse
{
	private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Integer save(final House house)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.save(house);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return house.getId();
	}

	public void update(final House house)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.update(house);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void remove(final House house)
	{
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			session.remove(house);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public House getById(final Integer id)
	{
		House house = null;
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("select h from House as h where h.id =:id");
			query.setParameter("id",id);
			house = (House)query.list().get(0);
			transaction.commit();
			session.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return house;
	}

	public List<House> getAll()
	{
		List <House> result = null;
		try
		{
			final Session session = sessionFactory.openSession();
			final Transaction transaction = session.beginTransaction();
			Query query = session.createQuery("select h from House as h");
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
