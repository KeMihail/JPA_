package com.epam.house.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.house.dao.IDaoPeople;
import com.epam.house.entity.People;


public class JPAPeopleDaoImpl implements IDaoPeople
{
	private EntityManager entityManager = Persistence.createEntityManagerFactory("house").createEntityManager();

	public Integer save(final People people)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(people);
		entityManager.getTransaction().commit();

		return people.getId();
	}

	public void update(final People people)
	{
		entityManager.getTransaction().begin();
		entityManager.merge(people);
		entityManager.getTransaction().commit();
	}

	public void remove(final People people)
	{
		if (getById(people.getId()) != null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(people);
			entityManager.getTransaction().commit();
		}
	}

	public People getById(final Integer id)
	{
		return entityManager.find(People.class, id);
	}

	public List<People> getAll()
	{
		TypedQuery<People> query = entityManager.createNamedQuery("people.getAll", People.class);
		return query.getResultList();
	}
}
