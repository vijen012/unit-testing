package com.unittesting.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImplTest {
	
	private Greeting greeting;
	
	@Before
	public void setUp() throws Exception {
		greeting = new GreetingImpl();
	}

	@After
	public void tearDown() throws Exception {
		greeting = null;
	}
	
	@Test
	public void greetShouldReturnAValidOutput() {
		String actual = greeting.greet("JUnit");
		assertNotNull(actual);
		assertEquals("Hello JUnit", actual );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowException_For_NameIsNull() {
		greeting.greet(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowException_For_NameIsEmpty() {
		greeting.greet("");
	}

}
