package com.unittesting.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class GreetingImplTest {
	
	private Greeting greeting;
	
	@BeforeEach
	public void setUp() throws Exception {
		greeting = new GreetingImpl();
	}

	@AfterEach
	public void tearDown() throws Exception {
		greeting = null;
	}
	
	@Test
	public void greetShouldReturnAValidOutput() {
		String actual = greeting.greet("JUnit");
		Assertions.assertNotNull(actual);
		Assertions.assertEquals("Hello JUnit", actual );
	}
	
	@Test
	public void greetShouldThrowException_For_NameIsNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet(null);	
		});
	}
	
	@Test
	public void greetShouldThrowException_For_NameIsEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet("");	
		});
	}

}
