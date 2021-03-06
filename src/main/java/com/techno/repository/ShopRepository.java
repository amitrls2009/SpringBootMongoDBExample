package com.techno.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techno.model.ShopDetails;

public interface ShopRepository extends MongoRepository<ShopDetails, Integer>{

	ShopDetails findByShopId(int shopId);
	
	ShopDetails findByShopIdIsAndShopLocationIs(int shopId,String shopLocation);
	
	ShopDetails findByShopIdOrShopLocation(int shopId,String shopLocation);
}
