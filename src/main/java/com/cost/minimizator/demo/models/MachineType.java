package com.cost.minimizator.demo.models;

public enum MachineType {

	LARGE("Large", 10),
	XLARGE("XLarge", 20),
	X2LARGE("2XLarge", 40),
	X4LARGE("4XLarge", 80),
	X8LARGE("8XLarge", 160),
	X10LARGE("10XLarge", 320);
	
	private String type;
	private int unitCapacity;
	
	private MachineType(String type, int unitCapacity) {
		this.type = type;
		this.unitCapacity = unitCapacity;
	}

	public String getType() {
		return type;
	}
	
	public Integer getUnitCapacity() {
		return unitCapacity;
	}

}
