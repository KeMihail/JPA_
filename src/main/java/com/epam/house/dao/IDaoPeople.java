package com.epam.house.dao;

import java.util.List;

import com.epam.house.entity.People;


public interface IDaoPeople
{
	Integer save(final People people);

	void update(final People people);

	void remove(final People people);

	People getById(final Integer id);

	List<People> getAll();
}
