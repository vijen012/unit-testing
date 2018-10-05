package com.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unittesting.entities.Item;
import com.unittesting.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping(path = "/dummyitems")
	public Item dummyItems() {
		return new Item(1, "Ball", 100, 2);
	}
	
	@GetMapping(path = "/items")
	public Item items() {
		return itemService.findItem();
	}
	
	@GetMapping(path = "/items-db")
	public List<Item> itemsFromDatabase() {
		return itemService.findAllItems();
	}
}
