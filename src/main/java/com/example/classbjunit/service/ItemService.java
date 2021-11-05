package com.example.classbjunit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.classbjunit.model.Item;
import com.example.classbjunit.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAll() {
		
		List<Item> items = itemRepository.findAll();
		
		for(Item item:items) {
			item.setValue(item.getQuantity()*item.getPrice());
		}
		return items;
	}

}
