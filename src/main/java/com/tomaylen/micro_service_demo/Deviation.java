package com.tomaylen.micro_service_demo;

import java.util.Collections;
import java.util.stream.Stream;

public class Deviation {

	private int numberOfValues = 3; // Number of integers from input data to be used in calculation of deviation
	private int working;
	private double output;

	public Deviation(String[] values) {

		this.working = Stream.of(values)
			// Puts greatest values first
			.sorted(Collections.reverseOrder())
			// Turn to an intStream
			.mapToInt(Integer::parseInt)
			// Only deal with the greatest numbers, discard the rest
			.limit(numberOfValues)
			// square each number
			.map(number -> number * number)
			// Sum all the squares
			.reduce(0, (number1, number2) -> number1 + number2);

		this.output = Math.sqrt(this.working);
	}

	public double getOutput() {
		return output;
	}

}