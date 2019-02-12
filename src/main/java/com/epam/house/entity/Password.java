package com.epam.house.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
@NamedQuery(name = "password.getAll",query = "select p from Password p")
public class Password
{
	@Id
	private Integer id;

	@Column
	private String number;
	@Column
	private String realize;

	@OneToOne(mappedBy = "password")
	private People people;

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public void setRealize(final String realize)
	{
		this.realize = realize;
	}

	public String getNumber()
	{
		return number;
	}

	public String getRealize()
	{
		return realize;
	}

	public void setPeople(final People people)
	{
		this.people = people;
	}

	public People getPeople()
	{
		return people;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(final Integer id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Password: id: " + id +", number: " + number + ", realize: " + realize;
		/*+ ", people=" + people;*/
	}
}
