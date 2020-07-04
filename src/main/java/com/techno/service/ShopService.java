package com.techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.techno.model.ShopDetails;
import com.techno.repository.ShopRepository;

@Service
@EnableMongoRepositories(basePackageClasses = com.techno.repository.ShopRepository.class)
public class ShopService {

	@Autowired
	ShopRepository shopRepository;

	public List<ShopDetails> getAllShop() {
		return shopRepository.findAll();
	}

	public Long saveShops() {
		ShopDetails shopDetails = new ShopDetails(1, "Bakery", "SahuNagar");
		ShopDetails shopDetails1 = new ShopDetails(2, "Grocery", "Pimpri");
		ShopDetails shopDetails2 = new ShopDetails(3, "Dwarka", "Vimannagar");
		ShopDetails shopDetails3 = new ShopDetails(4, "BigBazaar", "Chinchwad");
		ShopDetails shopDetails4 = new ShopDetails(5, "Dmart", "Thergaon");
		ShopDetails shopDetails5 = new ShopDetails(6, "Central", "Kharadi");
		shopRepository.save(shopDetails);
		shopRepository.save(shopDetails1);
		shopRepository.save(shopDetails2);
		shopRepository.save(shopDetails3);
		shopRepository.save(shopDetails4);
		shopRepository.save(shopDetails5);
		Long count = shopRepository.count();
		return count;

	}
	
	public ShopDetails getShop(int shopId)
	{
		return (ShopDetails)shopRepository.findByShopId(shopId);
	}
	
	public ShopDetails getShop(ShopDetails shopDetails)
	{
		return (ShopDetails)shopRepository.findByShopIdIsAndShopLocationIs(shopDetails.getShopId(), shopDetails.getShopLocation());
	}
	
	public ShopDetails getShopDetails(ShopDetails shopDetails)
	{
		return (ShopDetails)shopRepository.findByShopIdOrShopLocation(shopDetails.getShopId(), shopDetails.getShopLocation());
	}
}
