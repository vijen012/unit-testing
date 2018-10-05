package com.unittesting.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepositoryImpl implements CalculatorRepository {
	
	@Override
	public int[] findAllData() {
		return new int[] {1, 2, 3};
	}

}
