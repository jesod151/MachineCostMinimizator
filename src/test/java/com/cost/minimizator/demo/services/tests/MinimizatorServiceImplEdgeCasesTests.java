package com.cost.minimizator.demo.services.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.services.impl.MinimizatorServiceImpl;

class MinimizatorServiceImplEdgeCasesTests {

	private MinimizatorServiceImpl minimizatorServiceImpl = new MinimizatorServiceImpl();

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

	@Test
	void negativeUnitsShouldReturnIllegalArgumentException() {
		CalculateMinimumRequest request = new CalculateMinimumRequest();
		request.setHours(1);
		request.setUnits(-2);

		assertThrows(IllegalArgumentException.class, () -> {
			minimizatorServiceImpl.calculateMinimunCost(request);
		});
	}

	@Test
	void negativeHoursShouldReturnIllegalArgumentException() {
		CalculateMinimumRequest request = new CalculateMinimumRequest();
		request.setHours(-1);
		request.setUnits(10);

		assertThrows(IllegalArgumentException.class, () -> {
			minimizatorServiceImpl.calculateMinimunCost(request);
		});
	}

}
