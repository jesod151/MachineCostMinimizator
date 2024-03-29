package com.cost.minimizator.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cost.minimizator.demo.models.CalculateMinimumRequest;
import com.cost.minimizator.demo.models.CalculateMinimumResponse;
import com.cost.minimizator.demo.models.Machine;
import com.cost.minimizator.demo.models.MachineType;
import com.cost.minimizator.demo.models.RegionAllocation;
import com.cost.minimizator.demo.models.Regions;
import com.cost.minimizator.demo.services.MinimizatorService;

@Repository
public class MinimizatorServiceImpl implements MinimizatorService {

	private Machine [][] getMachines() {
		// Define the machines, each row will represent a region
		Machine [][] machines = 	   	       			   {{new Machine(MachineType.LARGE, 120),// New York
															 new Machine(MachineType.XLARGE, 230), 
															 new Machine(MachineType.X2LARGE, 450), 
															 new Machine(MachineType.X4LARGE, 774), 
															 new Machine(MachineType.X8LARGE, 1400), 
															 new Machine(MachineType.X10LARGE, 2820) }, 
						
															{new Machine(MachineType.LARGE, 140),  		// India
														     new Machine(MachineType.X2LARGE, 413), 
														     new Machine(MachineType.X4LARGE, 890), 
														     new Machine(MachineType.X8LARGE, 1300), 
														     new Machine(MachineType.X10LARGE, 2970) }, 
														
															{new Machine(MachineType.LARGE, 110), 		// China
															 new Machine(MachineType.XLARGE, 200),
															 new Machine(MachineType.X4LARGE, 670), 
															 new Machine(MachineType.X8LARGE, 1180) } };
		return machines;
	}
	
	@Override
	public CalculateMinimumResponse calculateMinimunCost(CalculateMinimumRequest request)
			throws IllegalArgumentException {

		if (request.getUnits() <= 0 || request.getUnits() % 10 != 0)
			throw new IllegalArgumentException("Invalid amount of units, should be a multiple of 10 greater than 0");

		if (request.getHours() <= 0)
			throw new IllegalArgumentException("Invalid amount of hours, should be greater than 0");

		List<List<Machine>> costsPerUnit = getCostPerUnit(getMachines());

		List<List<Machine>> allocatedResources = fitAsManyAsPosible(costsPerUnit, request.getUnits());

		CalculateMinimumResponse result = prettifyResult(allocatedResources, request.getHours());

		return result;

	}

	/**
	 * Calculates the cost per unit of each machine and sort them from cheaper to
	 * most expensive
	 *
	 * @param machines array
	 * @return a matrix array that contains all the machines sorted by cost per unit
	 */
	private List<List<Machine>> getCostPerUnit(Machine[][] machines) {

		List<List<Machine>> result = new ArrayList<List<Machine>>();

		for (Machine[] region : machines) {

			List<Machine> regionCosts = new ArrayList<Machine>();

			for (Machine machine : region) {
				machine.setCostPerUnit((double) machine.getCostPerHour() / machine.getType().getUnitCapacity());

				regionCosts.add(machine);
			}

			regionCosts.sort((a, b) -> a.getCostPerUnit().compareTo(b.getCostPerUnit()));
			result.add(regionCosts);
		}

		return result;
	}

	/**
	 * Fit all the machines possible from cheaper to expensive for each region
	 *
	 * @param costPerUnit    array (getCostPerUnit() output)
	 * @param requestedUnits
	 * @return a matrix array that contains all the machines that meet the requested
	 *         unit amount
	 */
	private List<List<Machine>> fitAsManyAsPosible(List<List<Machine>> costsPerUnit, Integer requestedUnits) {

		for (List<Machine> region : costsPerUnit) {

			Integer currentUnits = 0;

			for (Machine machine : region) {

				Integer remainingUnits = requestedUnits - currentUnits;

				if (remainingUnits == 0) {
					break;
				}

				Integer machineSelectedAmount = (Integer) remainingUnits / machine.getType().getUnitCapacity(),
						unitSelectedAmount = machine.getType().getUnitCapacity() * machineSelectedAmount;

				if (unitSelectedAmount > remainingUnits) {
					continue;
				}

				machine.setSelectedAmount(machineSelectedAmount);
				currentUnits += unitSelectedAmount;
			}

		}

		return costsPerUnit;
	}

	/**
	 * Calculates the total cost for each region
	 *
	 * @param allocatedResources array (fitAsManyAsPosible() output)
	 * @param requestedHours
	 * @return an array that contains each region total cost and the machines
	 *         requested
	 */
	private CalculateMinimumResponse prettifyResult(List<List<Machine>> allocatedResources, Integer requestedHours) {

		CalculateMinimumResponse result = new CalculateMinimumResponse();
		List<RegionAllocation> regionsResult = new ArrayList<RegionAllocation>();

		for (int region = 0; region < allocatedResources.size(); region++) {

			Integer total_cost = 0;
			List<Machine> regionMachines = allocatedResources.get(region);
			List<Machine> regionMachinesNames = new ArrayList<Machine>();

			for (Machine machine : regionMachines) {
				total_cost += machine.getCostPerHour() * machine.getSelectedAmount() * requestedHours;
				if (machine.getSelectedAmount() != 0) {
					regionMachinesNames.add(machine);
				}
			}

			RegionAllocation regionData = new RegionAllocation();
			regionData.setRegion(Regions.values()[region].getName());
			regionData.setTotal_cost("$" + total_cost);
			regionData.setMachines(regionMachinesNames);

			regionsResult.add(regionData);
		}

		result.setOutput(regionsResult);

		return result;
	}
}
