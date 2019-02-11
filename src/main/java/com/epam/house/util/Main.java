package com.epam.house.util;

import com.epam.house.dao.JPA.JPAHouseDao;
import com.epam.house.dao.hibernate.impl.BookDaoImpl;
import com.epam.house.dao.hibernate.impl.PeopleDaoImpl;
import com.epam.house.entity.House;
import com.epam.house.entity.People;


public class Main
{
	public static void main(final String[] args)
	{
		Integer id = 1;

		House house = new House();
		house.setNumber("m_number");
		house.setStreet("m_street");

		JPAHouseDao dao = new JPAHouseDao();
		house.setId(dao.save(house));

		house.setStreet("u_street");
		dao.update(house);

		System.out.println(house);
	}
}
