package com.techno.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techno.model.Mobile;

public interface MobileRepository extends MongoRepository<Mobile, String> {

	Mobile findByMobileId(String mobileId);

	List<Mobile> findByPriceGreaterThanEqual(int price);

}
