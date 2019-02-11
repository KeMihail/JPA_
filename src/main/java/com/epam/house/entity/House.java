package com.epam.house.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table
public class House
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String street;
	@Column
	private String number;

	@OneToMany(mappedBy = "house",fetch = FetchType.EAGER)
	private List<People> peoples;

	public House()
	{
	}

	public House(final String street, final String number)
	{
		this.street = street;
		this.number = number;
	}

	public void setId(final Integer id)
	{
		this.id = id;
	}

	public void setStreet(final String street)
	{
		this.street = street;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public Integer getId()
	{
		return id;
	}

	public String getStreet()
	{
		return street;
	}

	public String getNumber()
	{
		return number;
	}

	public List<People> getPeoples()
	{
		return peoples;
	}

	public void setPeoples(final List<People> peoples)
	{
		this.peoples = peoples;
	}

	@Override
	public String toString()
	{
		return "House: id=" + id + ", street: " + street + ", number='" + number;
	}
}
