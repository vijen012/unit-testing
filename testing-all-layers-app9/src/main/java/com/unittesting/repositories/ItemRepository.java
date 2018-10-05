package com.unittesting.repositories;

import org.springframework.data.repository.CrudRepository;

import com.unittesting.entities.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
