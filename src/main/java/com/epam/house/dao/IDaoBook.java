package com.epam.house.dao;

import java.util.List;

import com.epam.house.entity.Book;

public interface IDaoBook
{
	Integer save(final Book book);

	void update(final Book book);

	void remove (final Book book);

	Book getById(final Integer id);

	List<Book> getAll();
}
