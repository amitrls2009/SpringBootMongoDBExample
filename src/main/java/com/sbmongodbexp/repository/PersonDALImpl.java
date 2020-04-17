package com.sbmongodbexp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sbmongodbexp.model.Person;

@Repository
public class PersonDALImpl implements PersonDAL {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public PersonDALImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	// Same as Update
	public Person savePerson(Person person) {
		return mongoTemplate.save(person);
	}

	@Override
	public List<Person> getAllPerson() {
		return mongoTemplate.findAll(Person.class);
	}

	@Override
	public List<Person> getAllPersonPaginated(int pageNumber, int pageSize) {
		Query query = new Query();
		query.skip(pageNumber * pageSize);
		query.limit(pageSize);
		return mongoTemplate.find(query, Person.class);
	}

	@Override
	public Person findOneByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("personName").is(name));
		return mongoTemplate.findOne(query, Person.class);
	}

	@Override
	public List<Person> findByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("personName").is(name));
		return mongoTemplate.find(query, Person.class);

	}

	@Override
	public List<Person> findByAgeRange(int lowerBound, int upperBound) {
		Query query = new Query();
		query.addCriteria(Criteria.where("age").gte(lowerBound).andOperator(Criteria.where("age").lte(upperBound)));
		return mongoTemplate.find(query, Person.class);
	}

	@Override
	public List<Person> findByFavoriteBooks(List<String> favoriteBooks) {
		Query query = new Query();
		query.addCriteria(Criteria.where("favoriteBooks").in(favoriteBooks));
		return mongoTemplate.find(query, Person.class);
	}

	@Override
	public void updateMultiplePersonAge() {
		Query query = new Query();
		Update update = new Update().inc("age", 1);
		mongoTemplate.findAndModify(query, update, Person.class);
	}

	@Override
	public Person updatePersonAddressById(Person person) {
		Query query = new Query();
		query.addCriteria(Criteria.where("personId").is(person.getPersonId()));
		Update update = new Update().update("address", person.getAddress());
		return mongoTemplate.findAndModify(query, update, Person.class);
	}

	@Override
	public void deletePerson(Person person) {
		mongoTemplate.remove(person);
	}

	@Override
	public long countPerson() {
		return mongoTemplate.getCollection("person").count();
	}

}
