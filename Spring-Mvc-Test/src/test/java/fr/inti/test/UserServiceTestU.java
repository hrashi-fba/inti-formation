package fr.inti.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;


import org.hamcrest.core.IsEqual;
import org.junit.Assert; 
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.inti.test.entities.User;
import fr.inti.test.exception.UserFound;
import fr.inti.test.user.service.IUserService;

public class UserServiceTestU {
    private Logger LOGGER = Logger.getLogger("UserServiceTestU");
	private static  IUserService serviceUser;
	private static ClassPathXmlApplicationContext context;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		context = new ClassPathXmlApplicationContext("app.xml");
	    serviceUser = (IUserService)context.getBean("UserService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	   context.close();
	}

	@Test
	public void testAddUser() {
		User u  = new User("Boumaza2","Adel",30);
		try {
			serviceUser.addUser(u);
			assertNotNull(u.getId());
		} catch (UserFound e) {
			LOGGER.info(e.getMessage());
		}
	}

	@Test
	public void testUpdateUser() {
		
		User u = serviceUser.getOne(1L);
		u.setNom("Nom Modif");
		u.setAge(100);
		serviceUser.updateUser(u);
		User u2 = serviceUser.getOne(1L);
		Assert.assertThat(new String("Nom Modif"), IsEqual.equalTo(u2.getNom()));

	}

	@Test
	@Ignore
	public void testGetOne() {
		User u = serviceUser.getOne(1L);
		assertNotNull(u.getId());
		LOGGER.info("User rec"+u);
	}

	@Test
	@Ignore
	public void testGetUsers() {
		List<User> users = serviceUser.getUsers();
		assertTrue(users.size()>0);
		LOGGER.info("Users...."+users);
	}

	@Test
	@Ignore
	public void testRemove() {
		List<User> start = serviceUser.getUsers();//5
		serviceUser.remove(1L);
		List<User> end = serviceUser.getUsers();//4
		assertTrue(start.size()-1 == end.size());
	}

	@Test
	@Ignore
	public void testGetUserByName() {
		fail("Not yet implemented");
	}

}
