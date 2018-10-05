package com.unittesting.service;

import java.util.List;

import com.unittesting.entities.Item;

public interface ItemService {
	
	public Item findItem();
	public List<Item> findAllItems();
}
