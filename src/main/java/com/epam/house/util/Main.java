package com.epam.house.util;

import com.epam.house.dao.JPA.JPAHouseDaoImpl;
import com.epam.house.entity.House;


public class Main
{
	public static void main(final String[] args)
	{
		Integer id = 1;

		House house = new House();
		house.setNumber("m_number");
		house.setStreet("m_street");

		JPAHouseDaoImpl dao = new JPAHouseDaoImpl();
		house.setId(dao.save(house));

		house.setStreet("u_street");
		dao.update(house);

		System.out.println(house);
	}
}
