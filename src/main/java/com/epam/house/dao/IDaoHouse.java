package com.epam.house.dao;

import java.util.List;

import com.epam.house.entity.House;


public interface IDaoHouse
{
	Integer save(final House house);

	void update(final House house);

	void remove(final House house);

	House getById(final Integer id);

	List<House> getAll();
}
