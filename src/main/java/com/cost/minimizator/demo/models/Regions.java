package com.cost.minimizator.demo.models;

public enum Regions {

	NEW_YORK("New York", 0), 
	INDIA("India", 1), 
	CHINA("China", 2);

	private String name;
	private int row;

	private Regions(String name, int colunm) {
		this.name = name;
		this.row = colunm;
	}

	public String getName() {
		return name;
	}

	public int getRow() {
		return row;
	}

}
