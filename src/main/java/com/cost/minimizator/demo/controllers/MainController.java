package com.cost.minimizator.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.models.RegionAllocation;
import com.cost.minimizator.demo.services.MinimizatorService;

@RestController
public class MainController {

	@Autowired
	private MinimizatorService minimizatorService;

	@PostMapping("/minimumCost")
	public List<RegionAllocation> calculateMinimunCost(@RequestBody CalculateMinimumRequest request) {

		return minimizatorService.calculateMinimunCost(request);
	}

}
