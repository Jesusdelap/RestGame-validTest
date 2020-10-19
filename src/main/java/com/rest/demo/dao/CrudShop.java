package com.rest.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rest.demo.model.Shop;

public interface CrudShop extends CrudRepository<Shop, Long> {

	

}
