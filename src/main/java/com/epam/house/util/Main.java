package com.epam.house.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.house.dao.JPA.JPAHouseDaoImpl;
import com.epam.house.dao.hibernate.HouseDaoImpl;
import com.epam.house.entity.House;


public class Main
{
	public static void main(final String[] args)
	{
		final ApplicationContext context = new ClassPathXmlApplicationContext("/spring/context.xml");
		final House house = context.getBean("house",House.class);
		house.setStreet("street");
		house.setNumber("number");

		final HouseDaoImpl dao = context.getBean("houseDaoImpl",HouseDaoImpl.class);
		dao.save(house);
	}
}
