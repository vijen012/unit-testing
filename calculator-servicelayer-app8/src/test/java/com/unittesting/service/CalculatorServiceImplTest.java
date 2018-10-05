package com.unittesting.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.unittesting.repositories.CalculatorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceImplTest {

	@Mock
	private CalculatorRepository calculatorRepository;
	
	@Autowired
	@InjectMocks
	private CalculatorServiceImpl calcService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void calculateSum_ShouldReturnAValidValue() {
		int actualResult = calcService.calculateSum(new int[]{1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_ShouldReturnZeroWhenArrayIsEmpty() {
		int actualResult = calcService.calculateSum(new int[]{});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSum_ShouldReturnAValidValueWhenPassingOneValue() {
		int actualResult = calcService.calculateSum(new int[]{3});
		int expectedResult = 3;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingRepository_ShouldReturnAValidValue() {
		when(calculatorRepository.findAllData()).thenReturn(new int[] {1, 2, 4});
		int actualResult = calcService.calculateSumUsingRepository();
		int expectedResult = 7;
		assertEquals(expectedResult, actualResult);
		verify(calculatorRepository).findAllData();
	}
	
	@Test
	public void calculateSumUsingRepository_ShouldReturnZeroWhenArrayIsEmpty() {
		when(calculatorRepository.findAllData()).thenReturn(new int[] {});
		int actualResult = calcService.calculateSumUsingRepository();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
		verify(calculatorRepository).findAllData();
	}
	
	@Test
	public void calculateSumUsingRepository_ShouldReturnAValidValueWhenPassingOneValue() {
		when(calculatorRepository.findAllData()).thenReturn(new int[] {5});
		int actualResult = calcService.calculateSumUsingRepository();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
		verify(calculatorRepository).findAllData();
	}	

}
