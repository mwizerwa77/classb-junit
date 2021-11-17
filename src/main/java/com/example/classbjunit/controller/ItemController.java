package com.example.classbjunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.classbjunit.model.Item;
import com.example.classbjunit.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/all-items")
	public List<Item> getAll(){
		
		return itemService.getAll();
	}
	
	@GetMapping("/all-items/{id}")
	public ResponseEntity<?> getById(@PathVariable(name="id") int id){
		
		Item item = itemService.getById(id);
		if(item !=null) {
			return ResponseEntity.ok(item);
		}
		return ResponseEntity.notFound().build();
//		return ResponseEntity.ok().(new APIRe);

	}
}
