package com.tomaylen.micro_service_demo;

import java.util.Arrays;

public class Deviation {

	private int numberOfValues = 3; // Number of integers from input data to be used in calculation of deviation
	private int[] values;
	private int[] greatest;
	private double output;

	public Deviation(int[] values) {

		this.values = values;
		Arrays.sort(this.values);
		this.greatest = new int[numberOfValues];

		for (int i = 0; i < numberOfValues; i++) {
			this.greatest[i] = this.values[this.values.length - 1 - i];
		}

		int tally = 0;
		for (int i = 0; i < numberOfValues; i++) {
			tally += Math.pow(greatest[i], 2);
		}

		this.output = Math.sqrt(tally);
	}

	public double getOutput() {
		return output;
	}

}