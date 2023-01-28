package com.cost.minimizator.demo.models;

public enum MachineType {

	LARGE("Large"),
	XLARGE("XLarge"),
	X2LARGE("2XLarge"),
	X4LARGE("4XLarge"),
	X8LARGE("8XLarge"),
	X10LARGE("10XLarge");
	
	private String type;
	
	private MachineType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}
