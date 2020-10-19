package com.rest.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.demo.model.Shop;
import com.rest.demo.model.ShopGameStock;

public interface CrudShopGameStock extends CrudRepository<ShopGameStock, Long>{

}
