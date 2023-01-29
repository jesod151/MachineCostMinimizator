package com.cost.minimizator.demo.models;

import java.util.List;

public class RegionAllocation {

	private String region;
	private Integer total_cost;
	private List<Machine> machines;

	public RegionAllocation(String region, Integer total_cost, List<Machine> machines) {
		super();
		this.region = region;
		this.total_cost = total_cost;
		this.machines = machines;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(Integer total_cost) {
		this.total_cost = total_cost;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

}
