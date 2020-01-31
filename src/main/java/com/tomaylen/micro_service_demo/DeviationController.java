package com.tomaylen.micro_service_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviationController {

	@GetMapping("/deviation")
	public Deviation deviation(@RequestParam(value = "data") String[] data) {
		return new Deviation(data);
	}
}