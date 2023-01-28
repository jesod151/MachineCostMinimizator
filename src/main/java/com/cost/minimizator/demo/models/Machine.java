package com.cost.minimizator.demo.models;

public class Machine {

	private MachineType type;
	private Integer unitCapacity;
	private Integer costPerHour;

	public Machine(MachineType type, Integer unitCapacity, Integer costPerHour) {
		super();
		this.type = type;
		this.unitCapacity = unitCapacity;
		this.costPerHour = costPerHour;
	}

	public MachineType getType() {
		return type;
	}

	public void setType(MachineType type) {
		this.type = type;
	}

	public Integer getUnitCapacity() {
		return unitCapacity;
	}

	public void setUnitCapacity(Integer unitCapacity) {
		this.unitCapacity = unitCapacity;
	}

	public Integer getCostPerHour() {
		return costPerHour;
	}

	public void setCostPerHour(Integer costPerHour) {
		this.costPerHour = costPerHour;
	}

}
