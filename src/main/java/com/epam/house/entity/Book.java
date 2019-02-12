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
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQuery(name = "book.getAll",query = "select b from Book b")
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String name;
	@Column
	private String author;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_people", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "people_id"))
	private List<People> peoples;

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setAuthor(final String author)
	{
		this.author = author;
	}

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setPeoples(final List<People> peoples)
	{
		this.peoples = peoples;
	}

	public List<People> getPeoples()
	{
		return peoples;
	}

	@Override
	public String toString()
	{
		return "Book: id=" + id + ", name: " + name + ", author=" + author;
	}
}
