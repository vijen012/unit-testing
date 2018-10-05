package com.unittesting.mockito;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ATest {

	@Mock
	B b;
	
	private A a;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void usesVoidMethod_ShouldCallTheVoidMethod() throws Exception {
		//stubing out the void method by saying mockito do nothing when void mehtod called on b
		doNothing().when(b).voidMethod();
		
		//a.usesVoidMethod();
		assertSame(1, a.usesVoidMethod());
		verify(b).voidMethod();
	}

	@Test(expected = RuntimeException.class)
	public void usesVoidMethod_ShouldThrowRuntimeException() throws Exception {
		//stubing out throw exception class when void method called on b
		doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();
	}
	
	@Test(expected = RuntimeException.class)
	public void testConsecutiveCalls() throws Exception {
		/* stubing out do nothing when first time void method called and 
		 * throw exception class when second time void method called on b
		 */
		doNothing().doThrow(Exception.class).when(b).voidMethod();
		
		assertSame(1, a.usesVoidMethod());
		verify(b).voidMethod();
		
		a.usesVoidMethod();
	}	
}
