package com.unittesting.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unittesting.controller.ItemController;
import com.unittesting.entities.Item;
import com.unittesting.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void dummyItems_Basic() throws Exception {		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/dummyitems")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1, name:Ball, price:100, quantity:2}"))
				.andReturn();	
//		JSONAssert.assertEquals(expected, actual, strict);
	}
	
	@Test
	public void items_Basic() throws Exception {
		when(itemService.findItem()).thenReturn(new Item(3, "IPhone", 600, 40));
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/items")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:3, name:IPhone, price:600, quantity:40}"))
				.andReturn();
		verify(itemService, atLeast(1)).findItem();
		
//		JSONAssert.assertEquals(expected, actual, strict);
	}
	
	@Test
	public void itemsFromDatabase_Basic() throws Exception {
		when(itemService.findAllItems()).thenReturn(
				Arrays.asList(new Item(3, "IPhone", 600, 40),
						new Item(4, "TV", 500, 50))
				);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/items-db")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:3, name:IPhone, price:600, quantity:40}, {id:4, name:TV, price:500, quantity:50}]"))
				.andReturn();
		verify(itemService, atLeast(1)).findAllItems();
		
//		JSONAssert.assertEquals(expected, actual, strict);
	}

}
