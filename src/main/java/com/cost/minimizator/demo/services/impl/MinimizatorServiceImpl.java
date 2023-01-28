package com.cost.minimizator.demo.services.impl;

import org.springframework.stereotype.Repository;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.services.MinimizatorService;

@Repository
public class MinimizatorServiceImpl implements MinimizatorService {

	@Override
	public String calculateMinimunCost(CalculateMinimumRequest request) {
		return "Units: " + request.getUnits() + " Hours: " + request.getHours();
	}
}
