package com.epam.house.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class People
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;

	@ManyToOne
	private House house;

	@OneToOne
	@JoinColumn(name = "id")
	private Password password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_people", joinColumns = @JoinColumn(name = "people_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Book> books;

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public House getHouse()
	{
		return house;
	}

	public void setHouse(final House house)
	{
		this.house = house;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public void setPassword(final Password password)
	{
		this.password = password;
	}

	public Password getPassword()
	{
		return password;
	}

	public List<Book> getBooks()
	{
		return books;
	}

	public void setBooks(final List<Book> books)
	{
		this.books = books;
	}

	@Override
	public String toString()
	{
		return "People: id: " + id + ", name: " + name + ", email: " + email + ", house=" + house + ", books : " + books;
	}
}
