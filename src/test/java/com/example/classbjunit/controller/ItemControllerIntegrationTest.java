package com.example.classbjunit.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.classbjunit.model.Item;
import com.example.classbjunit.utils.APIResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
		
	@Test
	public void getAll_success() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items", String.class);
		
		//JSONAssert.assertEquals("[]", response, false);
		JSONAssert.assertEquals("[{id:101},{id:102},{id:103},{id:104}]", response, false);
	}
	
	@Test
	public void getById_successObject() {
		Item item = this.restTemplate.getForObject("/all-items/101", Item.class);
		
		assertEquals("Item1", item.getName());
		assertEquals(1000, item.getValue());
	}
	@Test
	public void getById_success() {
		ResponseEntity<Item> item = this.restTemplate.getForEntity("/all-items/101", Item.class);
		
		assertTrue(item.getStatusCode().is2xxSuccessful());
		assertEquals("Item1", item.getBody().getName());
		assertEquals(1000, item.getBody().getValue());
	}
	
	@Test
	public void getById_404() {
		ResponseEntity<APIResponse> item = 
				this.restTemplate.getForEntity("/all-items/1", APIResponse.class);
	
		assertTrue(item.getStatusCodeValue()==404);
		assertFalse(item.getBody().isStatus());
		assertEquals("Item not found", item.getBody().getMessage());
	}
	
	
	
	
}
