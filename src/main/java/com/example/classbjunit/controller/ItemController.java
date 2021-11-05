package com.example.classbjunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
