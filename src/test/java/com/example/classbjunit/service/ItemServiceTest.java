package com.example.classbjunit.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.classbjunit.dto.UpdateItemDto;
import com.example.classbjunit.model.Item;
import com.example.classbjunit.repository.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {


	@Mock
	private ItemRepository itemRepositoryMock;
	
	@InjectMocks
	private ItemService itemService;
	
	@Test
	public void getAll_withSomeElements() {

		when(itemRepositoryMock.findAll()).thenReturn(Arrays.asList(new Item(1,"Samuel",1,10),
				new Item(2,"Blessing",4,100)));
		assertEquals(10,itemService.getAll().get(0).getValue());
	}
	
	@Test
	public void update_Success() {
		UpdateItemDto dto = new UpdateItemDto("Shoes", 1000, 5);
		Item item = new Item(1, "Shoes", 1000, 5);
		when(itemRepositoryMock.findById(1)).thenReturn(Optional.of(item));
		when(itemRepositoryMock.existsByName(dto.getName())).thenReturn(true);
		when(itemRepositoryMock.save(item)).thenReturn(item);
		
		ResponseEntity<?> updateItem = itemService.updateItem(1, dto);
		assertTrue(updateItem.getStatusCode().is2xxSuccessful());
		
	}
	
	
	
	
	@Test
	public void update_404() {
		UpdateItemDto dto = new UpdateItemDto("Shoes", 1000, 5);
		Item item = new Item(1, "Shoes", 1000, 5);
		when(itemRepositoryMock.findById(1)).thenReturn(Optional.empty());
		
		
		ResponseEntity<?> updateItem = itemService.updateItem(1, dto);
		assertTrue(updateItem.getStatusCodeValue()==404);
		
	}
	
	@Test
	public void update_NameExists() {
		UpdateItemDto dto = new UpdateItemDto("Clothes", 1000, 5);
		Item item = new Item(1, "Shoes", 1000, 5);
		when(itemRepositoryMock.findById(1)).thenReturn(Optional.of(item));
		when(itemRepositoryMock.existsByName(dto.getName())).thenReturn(true);
		
		ResponseEntity<?> updateItem = itemService.updateItem(1, dto);
		assertTrue(updateItem.getStatusCodeValue()==400);
	}
	
	@Test
	public void update_sauve() {
		UpdateItemDto dto = new UpdateItemDto("Cars", 1000, 5);
		Item item = new Item(1, "Shoes", 1000, 5);
		when(itemRepositoryMock.findById(1)).thenReturn(Optional.of(item));
		when(itemRepositoryMock.existsByName(dto.getName())).thenReturn(false);
		item.setName(dto.getName());
		item.setPrice(dto.getPrice());
		item.setQuantity(dto.getQuantity());
		when(itemRepositoryMock.save(item)).thenReturn(item);
		
		ResponseEntity<?> updateItem = itemService.updateItem(1, dto);
		assertTrue(updateItem.getStatusCodeValue()==201);
	}
	
	
}
