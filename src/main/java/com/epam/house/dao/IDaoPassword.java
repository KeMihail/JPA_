package com.epam.house.dao;

import java.util.List;

import com.epam.house.entity.Password;


public interface IDaoPassword
{
	Integer save(final Password password);

	void update(final Password password);

	void remove(final Password password);

	Password getById(final Integer id);

	List<Password> getAll();
}
