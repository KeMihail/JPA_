package dao;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.house.dao.hibernate.impl.HouseDaoImpl;
import com.epam.house.entity.House;


public class HouseDaoTest
{
	private HouseDaoImpl dao = new HouseDaoImpl();
	private House source = new House();
	private Integer count_house;

	private static final String STREET = "t_street";
	private static final String NUMBER = "t_number";
	private static final String NUMBER_ = "t_number_";

	@Before
	public void setUp()
	{
		count_house = dao.getAll().size();

		source.setStreet(STREET);
		source.setNumber(NUMBER);
		source.setId(dao.save(source));
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

	/*@After
	public void cleanData(){
		houseDao.remove(source);
	}*/
}
