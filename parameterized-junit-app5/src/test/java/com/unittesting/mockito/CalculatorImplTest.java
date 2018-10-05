package com.unittesting.mockito;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorImplTest {
	
	private Calculator calc;
	private int num1;
	private int num2;
	private int expectedResult;
	
	public CalculatorImplTest(int num1, int num2, int expectedResult) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.expectedResult = expectedResult;
	}

	@Parameters
	public static Collection<Integer[]> data() {
		return Arrays.asList(new Integer[][] {
			{1, 3, 4},
			{2, -1, 1},
			{7, 8, 15}
		});
	}
	
	@Before
	public void setUp() throws Exception {
		calc = new CalculatorImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int actualResult = calc.add(num1, num2);
		assertEquals(expectedResult, actualResult);
	}

}
