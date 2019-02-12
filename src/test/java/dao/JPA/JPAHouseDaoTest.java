package dao.JPA;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.house.dao.JPA.JPAHouseDaoImpl;
import com.epam.house.entity.House;


public class JPAHouseDaoTest
{
	private JPAHouseDaoImpl dao = new JPAHouseDaoImpl();
	private House source = new House();
	private Integer count_house;

	private static final String STREET = "jpa_street";
	private static final String NUMBER = "jpa_number";
	private static final String NUMBER_ = "jpa_number_";

	@Before
	public void setUp(){

		count_house = dao.getAll().size();

		source.setStreet(STREET);
		source.setNumber(NUMBER);
		dao.save(source);
	}

	@Test
	public void testHouse(){

		// getById:
		House target = dao.getById(source.getId());

		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(),target.getId());
		Assert.assertEquals(source.getNumber(),target.getNumber());
		Assert.assertEquals(source.getStreet(),target.getStreet());

		// update:
		source.setNumber(NUMBER_);
		dao.update(source);

		target = dao.getById(source.getId());
		Assert.assertNotNull(target);
		Assert.assertEquals(source.getId(),target.getId());
		Assert.assertEquals(source.getNumber(),target.getNumber());
		Assert.assertEquals(source.getStreet(),target.getStreet());

		// getAll:
		Assert.assertEquals(++count_house,Integer.valueOf(dao.getAll().size()));

		// delete
		dao.remove(source);
		Assert.assertNull(dao.getById(source.getId()));
	}

	@After
	public void cleanData(){
		dao.remove(source);
	}

}
