package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.house.dao.hibernate.impl.BookDaoImpl;
import com.epam.house.entity.Book;


public class BookDaoTest
{
	private BookDaoImpl dao = new BookDaoImpl();
	private Book source = new Book();

	private Integer count_book;
	private static final String AUTHOR = "t_author";
	private static final String NAME = "t_name";
	private static final String NAME_ = "t_name_";

	@Before
	public void setUp(){

		count_book = dao.getAll().size();

		source.setAuthor(AUTHOR);
		source.setName(NAME);
		source.setId(dao.save(source));

	}

	@Test
	public void testBook(){

		// getById:
		Book target = dao.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(),source.getId());
		Assert.assertEquals(target.getName(),NAME);
		Assert.assertEquals(target.getAuthor(),AUTHOR);

		// update:
		source.setName(NAME_);
		dao.update(source);

		target = dao.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getName(),NAME_);

		// getAll:
		Assert.assertEquals(++count_book,Integer.valueOf(dao.getAll().size()));

		// remove:
		dao.remove(source);

		Assert.assertNull(dao.getById(source.getId()));
	}

	@After
	public void cleanData(){

	}
}
