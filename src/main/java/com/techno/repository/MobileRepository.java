package com.techno.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.techno.model.Mobile;

public interface MobileRepository extends MongoRepository<Mobile, Integer> {

}
