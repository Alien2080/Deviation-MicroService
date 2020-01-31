package com.tomaylen.micro_service_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviationController {

	@GetMapping("/deviation")
	public Deviation deviation(@RequestParam(value = "data", defaultValue = "1,2,3") String[] data) {
        int size = data.length;
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
           arr[i] = Integer.parseInt(data[i]);
        }
		return new Deviation(arr);
	}
}