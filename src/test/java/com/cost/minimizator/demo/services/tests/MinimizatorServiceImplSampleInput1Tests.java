package com.cost.minimizator.demo.services.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.models.CalculateMinimumResponse;
import com.cost.minimizator.demo.models.Machine;
import com.cost.minimizator.demo.models.Regions;
import com.cost.minimizator.demo.services.impl.MinimizatorServiceImpl;

class MinimizatorServiceImplSampleInput1Tests {

	private MinimizatorServiceImpl minimizatorServiceImpl = new MinimizatorServiceImpl();

	private CalculateMinimumRequest getRequestSampleInput() {

		CalculateMinimumRequest request = new CalculateMinimumRequest();
		request.setHours(1);
		request.setUnits(1150);

		return request;
	}

	private CalculateMinimumResponse getSampleInputResult() {
		CalculateMinimumRequest request = getRequestSampleInput();

		CalculateMinimumResponse testResult = minimizatorServiceImpl.calculateMinimunCost(request);

		return testResult;
	}

	@Test
	void sampleInputShouldReturn10150TotalCostForNewYork() {

		CalculateMinimumResponse testResult = getSampleInputResult();

		assertEquals("$10150", testResult.getOutput().get(Regions.NEW_YORK.getRow()).getTotal_cost());

	}

	@Test
	void sampleInputShouldReturn1150UnitsForNewYork() {

		CalculateMinimumRequest sampleRequest1 = getRequestSampleInput();
		CalculateMinimumResponse testResult = getSampleInputResult();

		Integer unitsAmount = 0;

		for (Machine machine : testResult.getOutput().get(Regions.NEW_YORK.getRow()).getMachines()) {
			unitsAmount += machine.getSelectedAmount() * machine.getType().getUnitCapacity();
		}

		assertEquals(sampleRequest1.getUnits(), unitsAmount);

	}

	@Test
	void sampleInputShouldReturn9520TotalCostForIndia() {

		CalculateMinimumResponse testResult = getSampleInputResult();

		assertEquals("$9520", testResult.getOutput().get(Regions.INDIA.getRow()).getTotal_cost());

	}

	@Test
	void sampleInputShouldReturn1150UnitsForIndia() {

		CalculateMinimumRequest sampleRequest1 = getRequestSampleInput();
		CalculateMinimumResponse testResult = getSampleInputResult();

		Integer unitsAmount = 0;

		for (Machine machine : testResult.getOutput().get(Regions.INDIA.getRow()).getMachines()) {
			unitsAmount += machine.getSelectedAmount() * machine.getType().getUnitCapacity();
		}

		assertEquals(sampleRequest1.getUnits(), unitsAmount);

	}

	@Test
	void sampleInputShouldReturn8570TotalCostForChina() {

		CalculateMinimumResponse testResult = getSampleInputResult();

		assertEquals("$8570", testResult.getOutput().get(Regions.CHINA.getRow()).getTotal_cost());

	}

	@Test
	void sampleInputShouldReturn1150UnitsForChina() {

		CalculateMinimumRequest sampleRequest1 = getRequestSampleInput();
		CalculateMinimumResponse testResult = getSampleInputResult();

		Integer unitsAmount = 0;

		for (Machine machine : testResult.getOutput().get(Regions.CHINA.getRow()).getMachines()) {
			unitsAmount += machine.getSelectedAmount() * machine.getType().getUnitCapacity();
		}

		assertEquals(sampleRequest1.getUnits(), unitsAmount);

	}

}
