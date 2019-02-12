package dao.JPA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.house.dao.JPA.JPABookDaoImpl;
import com.epam.house.entity.Book;


public class JPABookDaoTest
{
	private JPABookDaoImpl dao = new JPABookDaoImpl();
	private Book source = new Book();

	private Integer count_book;
	private static final String AUTHOR = "jpa_author";
	private static final String NAME = "jpa_name";
	private static final String NAME_ = "jpa_name_";

	@Before
	public void setUp()
	{

		count_book = dao.getAll().size();

		source.setAuthor(AUTHOR);
		source.setName(NAME);
		source.setId(dao.save(source));
	}

	@Test
	public void testBook()
	{
		// getById:
		Book target = dao.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(), source.getId());
		Assert.assertEquals(target.getName(), NAME);
		Assert.assertEquals(target.getAuthor(), AUTHOR);

		// update:
		source.setName(NAME_);
		dao.update(source);

		target = dao.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getName(), NAME_);

		// getAll:
		Assert.assertEquals(++count_book, Integer.valueOf(dao.getAll().size()));

		// remove:
		dao.remove(source);

		Assert.assertNull(dao.getById(source.getId()));
	}

	@After
	public void cleanData()
	{

	}

}
