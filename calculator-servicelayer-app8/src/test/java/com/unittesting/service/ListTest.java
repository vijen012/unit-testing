package com.unittesting.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {
	
	@Mock
	private List<Integer> list;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void size_basic() {
		when(list.size()).thenReturn(5);
		assertEquals(5, list.size());
		verify(list).size();
	}
	
	@Test
	public void size_ReturnDifferentValues() {
		when(list.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, list.size());
		assertEquals(10, list.size());
		verify(list, atLeast(1)).size();
	}
	
	@Test
	public void size_ReturnWithParameters() {
		when(list.get(0)).thenReturn(5);
		assertTrue(5==list.get(0));
		assertTrue(null == list.get(1));
		verify(list, times(2)).get(anyInt());
	}
	
	@Test
	public void size_ReturnWithGenericParameters() {
		when(list.get(anyInt())).thenReturn(5);
		assertTrue(5 == list.get(0));
		assertTrue(5 == list.get(1));
		verify(list, atLeast(1)).get(anyInt());
	}
	
	@Test
	public void argumentCapturing() {
		/* SUT -  lets say we are testing a function in service class and inside the function
		 * there is a function call [list.add(5)] so i want to capture the parameter value
		 * and verify it
		 */
		list.add(5);
		
		//Verification
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		verify(list).add(captor.capture());
		
		assertTrue(5 == captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		/* SUT -  lets say we are testing a function in service class and inside the function
		 * there are multiple function call [list.add(5), list.add(3)] so i want to capture the value of
		 * parater values and verify it
		 */
		list.add(5); // these method will be called in service function
		list.add(3); // these method will be called in service function
		
		//Verification
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		verify(list, atLeast(1)).add(captor.capture());
		
		List<Integer> allValues = captor.getAllValues();
		assertTrue(5 == allValues.get(0));
		assertTrue(3 == allValues.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test4");
	}	

}
