package com.epam.house.util;

import com.epam.house.dao.JPA.JPAHouseDao;
import com.epam.house.dao.hibernate.impl.BookDaoImpl;
import com.epam.house.dao.hibernate.impl.PeopleDaoImpl;
import com.epam.house.entity.House;
import com.epam.house.entity.People;

import java.util.List;


public class Main {
    public static void main(final String[] args) {
        JPAHouseDao dao = new JPAHouseDao();

	/*	House house = new House();
		house.setNumber("m_number_one");
		house.setStreet("m_street_one");
		house.setId(dao.save(house));
		  house.setId(dao.save(house));
*/


        final List<House> list = dao.getAll();
        for (final House item: list) {
            System.out.println(item);
        }
    }
}
