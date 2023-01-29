package com.cost.minimizator.demo.services;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.models.CalculateMinimumResponse;

public interface MinimizatorService {

	CalculateMinimumResponse calculateMinimunCost(CalculateMinimumRequest request) throws IllegalArgumentException;

}
