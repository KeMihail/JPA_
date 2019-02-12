package dao.JPA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.house.dao.JPA.JPAPeopleDaoImpl;
import com.epam.house.entity.People;


public class JPAPeoppleDaoTest
{
	private JPAPeopleDaoImpl dao = new JPAPeopleDaoImpl();
	private People source = new People();

	private Integer count_people;
	private static final String NAME = "jpa_name";
	private static final String EMAIL = "jpa_email";
	private static final String EMAIL_ = "jpa_email_";

	@Before
	public void setUp()
	{

		count_people = dao.getAll().size();

		source.setName(NAME);
		source.setEmail(EMAIL);
		source.setId(dao.save(source));
	}

	@Test
	public void testPeople()
	{

		// getById:
		People target = dao.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(), source.getId());
		Assert.assertEquals(target.getName(), NAME);
		Assert.assertEquals(target.getEmail(), EMAIL);

		// update:
		source.setEmail(EMAIL_);
		dao.update(source);

		target = dao.getById(source.getId());
		Assert.assertNotNull(target);
		Assert.assertEquals(target.getEmail(), EMAIL_);

		// getAll:
		Assert.assertEquals(++count_people, Integer.valueOf(dao.getAll().size()));

		//remove:
		dao.remove(source);
		Assert.assertNull(dao.getById(source.getId()));

	}

	@After
	public void cleanData()
	{
		dao.remove(source);
	}
}
