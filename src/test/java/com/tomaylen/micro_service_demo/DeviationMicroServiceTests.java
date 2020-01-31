package com.tomaylen.micro_service_demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DeviationMicroServiceTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/deviation?data=1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("1.0")));
	}

	@Test
	public void shouldReturnExpectedValue1() throws Exception {
		this.mockMvc.perform(get("/deviation?data=5,4,6,1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("8.77")));
	}

	@Test
	public void shouldReturnExpectedValue2() throws Exception {
		this.mockMvc.perform(get("/deviation?data=0")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("0.0")));
	}

	@Test
	public void shouldReturnExpectedValue3() throws Exception {
		this.mockMvc.perform(get("/deviation?data=-1,-4,-6")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(deviationHelper(-1, -4, -6))));
	}

	@Test
	public void shouldReturnExpectedValue4() throws Exception {
		this.mockMvc.perform(get("/deviation?data=0,0,0,0,0,0,3")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(deviationHelper(0, 0, 3))));
	}

	@Test
	public void shouldReturnExpectedValue5() throws Exception {
		this.mockMvc.perform(get("/deviation?data=-100,0,0,67,100,0,3")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(deviationHelper(100, 67, 3))));
	}

	String deviationHelper(int number1, int number2, int number3){
		return Double.toString(Math.sqrt(Math.pow(number1, 2) + Math.pow(number2, 2) + Math.pow(number3, 2)));
	}
}