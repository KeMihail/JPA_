package dao;


import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.house.dao.IDaoHouse;
import com.epam.house.dao.hibernate.HouseDaoImpl;
import com.epam.house.entity.House;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class HouseDaoTest
{
	@Resource(name = "houseDaoJPA")
	private IDaoHouse dao;

	@Resource(name = "house")
	private House source;

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

	@After
	public void cleanData(){
		dao.remove(source);
	}
}
