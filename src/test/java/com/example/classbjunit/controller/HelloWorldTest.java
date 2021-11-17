package com.example.classbjunit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorld.class)
public class HelloWorldTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		//call GET "/hello-helloWorld_basicworld" application/json
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
		.get("/hello-world")
		.accept(MediaType.APPLICATION_JSON);
		
		 MvcResult result = mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("hello world"))
				.andReturn();
		
		//verify "Hello world"
	assertEquals("hello world", result.getResponse().getContentAsString());
	}
}
