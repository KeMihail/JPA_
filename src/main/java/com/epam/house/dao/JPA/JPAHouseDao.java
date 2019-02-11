package com.epam.house.dao.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epam.house.dao.IDaoHouse;
import com.epam.house.entity.House;


public class JPAHouseDao implements IDaoHouse {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.epam.house.entity");
    private EntityManager entityManager;

    public Integer save(final House house) {
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(house);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return house.getId();
    }

    public void update(final House house) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(house);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void remove(final House house) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final House house1 = entityManager.find(House.class, house.getId());
        entityManager.remove(house1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public House getById(final Integer id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final House house = entityManager.find(House.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return house;
    }

    public List<House> getAll() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        final List<House> result = entityManager.createQuery("select h from House as h").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}
