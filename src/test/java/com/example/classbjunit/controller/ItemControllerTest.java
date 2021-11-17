package com.example.classbjunit.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.classbjunit.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.classbjunit.model.Item;
import com.example.classbjunit.service.ItemService;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.classbjunit.model.Item;
import com.example.classbjunit.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

   @MockBean
   private ItemService itemServiceMock;

   @Autowired
   private MockMvc mockMvc;

   @Test
   public void getAll_success() throws Exception {
      List<Item> asList = Arrays.asList(new Item(1, "Samuel", 1, 10),
            new Item(2, "Blessing", 4, 100));
      when(itemServiceMock.getAll()).thenReturn(asList);

      MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/all-items")
            .accept(MediaType.APPLICATION_JSON);

      MvcResult result = mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(content().json("[{\"id\":1,\"name\":\"Samuel\",\"price\":1},{\"id\":2,\"name\":\"Blessing\",\"price\":4}]"))
            .andReturn();

   }


   @Test
   public void getById() throws Exception {
      Item item = new Item(1, "clothes", 21, 10);

      when(itemServiceMock.getById(anyInt())).thenReturn(item);

      MockHttpServletRequestBuilder request = MockMvcRequestBuilders
            .get("/all-items/1")
            .accept(MediaType.APPLICATION_JSON);

      MvcResult result = mockMvc
            .perform(request)
            .andExpect(status().isOk())
            .andExpect(content().json("{\"id\":1,\"name\":\"clothes\",\"price\":21}"))
            .andReturn();
   }
   
   @Test
   public void getByeOne_404() throws Exception {
	   Item item = new Item(1, "Samuel", 10, 10);

	      when(itemServiceMock.getById(item.getId())).thenReturn(item);

	      MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	            .get("/all-items/1")
	            .accept(MediaType.APPLICATION_JSON);

	      MvcResult result = mockMvc
	            .perform(request)
	            .andExpect(status().isNotFound())
	            .andExpect(content().string(""))
//	            .andExpect(content().json(null))
	            .andReturn();
   }


}