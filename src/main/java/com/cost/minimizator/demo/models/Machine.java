package com.cost.minimizator.demo.models;

public class Machine {

	private MachineType type;
	private Integer costPerHour;
	private Double costPerUnit = Double.MAX_VALUE;
	private Integer selectedAmount = 0;

	public Machine(MachineType type, Integer costPerHour) {
		super();
		this.type = type;
		this.costPerHour = costPerHour;
	}

	public MachineType getType() {
		return type;
	}

	public void setType(MachineType type) {
		this.type = type;
	}

	public Integer getCostPerHour() {
		return costPerHour;
	}

	public void setCostPerHour(Integer costPerHour) {
		this.costPerHour = costPerHour;
	}

	public Double getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(Double costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public Integer getSelectedAmount() {
		return selectedAmount;
	}

	public void setSelectedAmount(Integer amount) {
		this.selectedAmount = amount;
	}

}
