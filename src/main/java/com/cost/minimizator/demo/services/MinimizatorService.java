package com.cost.minimizator.demo.services;

import java.util.List;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.models.RegionAllocation;

public interface MinimizatorService {

	List<RegionAllocation> calculateMinimunCost(CalculateMinimumRequest request) throws IllegalArgumentException;

}
