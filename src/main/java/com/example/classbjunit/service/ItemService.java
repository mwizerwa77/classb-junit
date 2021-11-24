package com.example.classbjunit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.classbjunit.dto.UpdateItemDto;
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

	public Item getById(int id) {
		Optional<Item> findById = itemRepository.findById(id);
		if(findById.isPresent()) {
			Item item = findById.get();	
			item.setValue(item.getPrice()*item.getQuantity());
			
			return item;
		}
		return null;
	}
	public ResponseEntity<?> updateItem(int id,UpdateItemDto dto) {
		Optional<Item> findById = itemRepository.findById(id);
		if(findById.isPresent()) {
			Item item = findById.get();	
			
			if(itemRepository.existsByName(dto.getName()) && 
					!(item.getName().equalsIgnoreCase(dto.getName()))) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("item name exists already!");
			}
			
			item.setName(dto.getName());
			item.setPrice(dto.getPrice());
			item.setQuantity(dto.getQuantity());
			itemRepository.save(item);			
			return ResponseEntity.status(HttpStatus.CREATED).body(item);
			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("item does not exist");
		
	}
	
}
