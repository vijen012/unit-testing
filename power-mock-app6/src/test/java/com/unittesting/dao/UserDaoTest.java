package com.unittesting.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.unittesting.domain.User;
import com.unittesting.util.IDGenerator;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IDGenerator.class)
public class UserDaoTest {

	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao = new UserDao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		mockStatic(IDGenerator.class);
		
		when(IDGenerator.generateID()).thenReturn(1);
		int result = userDao.createUser(new User());
		assertEquals(1, result);
		
		verifyStatic();
	}

}
