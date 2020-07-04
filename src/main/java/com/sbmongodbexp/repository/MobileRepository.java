package com.sbmongodbexp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.sbmongodbexp.model.Mobile;

public interface MobileRepository extends MongoRepository<Mobile, Integer> {

}
