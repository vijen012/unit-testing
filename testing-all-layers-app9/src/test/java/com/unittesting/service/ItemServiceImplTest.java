package com.unittesting.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.unittesting.entities.Item;
import com.unittesting.repositories.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {
	
	@Mock
	private ItemRepository itemRepository;
	
	@Autowired
	@InjectMocks
	private ItemServiceImpl itemService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFinadAllItems_Basic() {
		when(itemRepository.findAll()).thenReturn(
				Arrays.asList(new Item(3, "IPhone", 600, 40),
						new Item(4, "TV", 500, 50))
				);
		List<Item> itemList = itemService.findAllItems();
		//Testing the business logic after reteriving data from repository
		itemList.stream().forEach(item -> assertEquals(item.getPrice() * item.getQuantity(), item.getValue()));
		verify(itemRepository, atLeast(1)).findAll();
	}

}
