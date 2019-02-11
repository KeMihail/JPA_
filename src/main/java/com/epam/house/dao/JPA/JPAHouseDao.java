package com.epam.house.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epam.house.dao.IDaoHouse;
import com.epam.house.entity.House;


public class JPAHouseDao implements IDaoHouse
{
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.epam.house.entity");
	private EntityManager entityManager;

	public Integer save(final House house)
	{
		try
		{
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(house);
			entityManager.getTransaction().commit();
			entityManager.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		return house.getId();
	}

	public void update(final House house)
	{
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(house);
			entityManager.getTransaction().commit();
			entityManager.close();
	}

	public void remove(final House house)
	{

	}

	public House getById(final Integer id)
	{
		return null;
	}

	public List<House> getAll()
	{
		return null;
	}
}
