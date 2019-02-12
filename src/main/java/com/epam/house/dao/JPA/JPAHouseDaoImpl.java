package com.epam.house.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.house.dao.IDaoHouse;
import com.epam.house.entity.House;


public class JPAHouseDaoImpl implements IDaoHouse
{
	private EntityManager entityManager = Persistence.createEntityManagerFactory("house").createEntityManager();

	public Integer save(final House house)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(house);
		entityManager.getTransaction().commit();

		return house.getId();
	}

	public void update(final House house)
	{
		entityManager.getTransaction().begin();
		entityManager.merge(house);
		entityManager.getTransaction().commit();
	}

	public void remove(final House house)
	{
		entityManager.getTransaction().begin();
		if (getById(house.getId()) != null)
		{
			entityManager.remove(getById(house.getId()));
		}
		entityManager.getTransaction().commit();
	}

	public House getById(final Integer id)
	{
		return entityManager.find(House.class, id);
	}

	public List<House> getAll()
	{
		TypedQuery<House> namedQuery = entityManager.createNamedQuery("house.getAll()", House.class);
		return namedQuery.getResultList();
	}
}
