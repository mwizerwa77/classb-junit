package com.example.classbjunit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
}
