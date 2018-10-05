package com.unittesting.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unittesting.repositories.CalculatorRepository;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	private CalculatorRepository calculatorRepository;
	
	@Override
	public int calculateSum(int[] data) {
		//Arrays.stream(data).reduce(Integer::sum).orElse(0);
		return Arrays.stream(data).sum();
	}
	
	@Override
	public int calculateSumUsingRepository() {
		return Arrays.stream(calculatorRepository.findAllData()).sum();
	}

}
