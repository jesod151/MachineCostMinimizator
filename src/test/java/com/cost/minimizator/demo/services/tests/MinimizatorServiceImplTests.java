package com.cost.minimizator.demo.services.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.models.CalculateMinimumResponse;
import com.cost.minimizator.demo.models.Regions;
import com.cost.minimizator.demo.services.impl.MinimizatorServiceImpl;

class MinimizatorServiceImplTests {

	private MinimizatorServiceImpl minimizatorServiceImpl = new MinimizatorServiceImpl();

	@Test
	void DocumentSampleInput1() {

		CalculateMinimumRequest request = new CalculateMinimumRequest();
		request.setHours(1);
		request.setUnits(1150);

		CalculateMinimumResponse testResult = minimizatorServiceImpl.calculateMinimunCost(request);

		assertEquals("$10150", testResult.getOutput().get(Regions.NEW_YORK.getRow()).getTotal_cost());

		/*
		 * for(Machine machine: testResult.getOutput())
		 * 
		 * 
		 * assertEquals(request.getUnits(), testResult.getOutput().get();
		 */

	}

	@Test
	void zeroHoursShouldReturnIllegalArgumentException() {
		CalculateMinimumRequest request = new CalculateMinimumRequest();
		request.setHours(0);
		request.setUnits(1150);

		assertThrows(IllegalArgumentException.class, () -> {
			minimizatorServiceImpl.calculateMinimunCost(request);
		});
	}

	@Test
	void zeroUnitsShouldReturnIllegalArgumentException() {
		CalculateMinimumRequest request = new CalculateMinimumRequest();
		request.setHours(1);
		request.setUnits(0);

		assertThrows(IllegalArgumentException.class, () -> {
			minimizatorServiceImpl.calculateMinimunCost(request);
		});
	}

	@Test
	void nonMultipleOfTenUnitsShouldReturnIllegalArgumentException() {
		CalculateMinimumRequest request = new CalculateMinimumRequest();
		request.setHours(1);
		request.setUnits(2);

		assertThrows(IllegalArgumentException.class, () -> {
			minimizatorServiceImpl.calculateMinimunCost(request);
		});
	}

}
