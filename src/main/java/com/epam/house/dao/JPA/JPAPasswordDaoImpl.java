package com.epam.house.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.house.dao.IDaoPassword;
import com.epam.house.entity.Password;


public class JPAPasswordDaoImpl implements IDaoPassword
{
	private EntityManager entityManager = Persistence.createEntityManagerFactory("house").createEntityManager();

	public Integer save(final Password password)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(password);
		entityManager.getTransaction().commit();

		return password.getId();
	}

	public void update(final Password password)
	{
		entityManager.getTransaction().begin();
		entityManager.merge(password);
		entityManager.getTransaction().commit();
	}

	public void remove(final Password password)
	{
		if (getById(password.getId()) != null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(password);
			entityManager.getTransaction().commit();
		}
	}

	public Password getById(final Integer id)
	{
		return entityManager.find(Password.class, id);
	}

	public List<Password> getAll()
	{
		TypedQuery<Password> query = entityManager.createNamedQuery("password.getAll", Password.class);
		return query.getResultList();
	}
}
