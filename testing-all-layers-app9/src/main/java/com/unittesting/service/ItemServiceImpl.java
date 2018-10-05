package com.unittesting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unittesting.entities.Item;
import com.unittesting.repositories.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item findItem() {
		return new Item(2, "Laptop", 1000, 3);
	}

	@Override
	public List<Item> findAllItems() {
		List<Item> itemList = new ArrayList<>();
		itemRepository.findAll().forEach(itemList::add);
		itemList = itemList.stream().map(item -> {
			item.setValue(item.getPrice() * item.getQuantity());
			return item;
		}).collect(Collectors.toList());
		
		return itemList;
	}

}
