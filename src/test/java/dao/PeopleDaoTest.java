package dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.house.dao.IDaoPeople;
import com.epam.house.dao.hibernate.PeopleDaoImpl;
import com.epam.house.entity.People;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class PeopleDaoTest
{
	@Resource(name = "peopleDaoJPA")
	private IDaoPeople dao;

	@Resource(name = "people")
	private People source;

	private Integer count_people;
	private static final String NAME = "t_name";
	private static final String EMAIL = "t_email";
	private static final String EMAIL_ = "t_email_";

	@Before
	public void setUp(){

		count_people = dao.getAll().size();

		source.setName(NAME);
		source.setEmail(EMAIL);
		source.setId(dao.save(source));
	}

	@Test
	public void testPeople(){

		// getById:
		People target = dao.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(target.getId(),source.getId());
		Assert.assertEquals(target.getName(),NAME);
		Assert.assertEquals(target.getEmail(),EMAIL);

		// update:
		source.setEmail(EMAIL_);
		dao.update(source);

		target = dao.getById(source.getId());
		Assert.assertNotNull(target);
		Assert.assertEquals(target.getEmail(),EMAIL_);

		// getAll:
		Assert.assertEquals(++count_people,Integer.valueOf(dao.getAll().size()));

		//remove:

		dao.remove(source);
		Assert.assertNull(dao.getById(source.getId()));

	}

	@After
	public void cleanData(){

	}
}
