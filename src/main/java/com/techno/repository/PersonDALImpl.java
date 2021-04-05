package com.techno.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.techno.model.Person;

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

	//Projection
	@Override
	public List<Person> getAllPersonProjected() {
		Query query = new Query();
		query.fields().exclude("favoriteBooks");
		return mongoTemplate.find(query, Person.class);
	}

	//Aggregation
	@Override
	public List<Person> getAllPersonAggregated() {		
		ProjectionOperation projectStage = Aggregation.project("personName", "age");
		Aggregation aggregation  = Aggregation.newAggregation(projectStage);
		AggregationResults<Person> output  = mongoTemplate.aggregate(aggregation,"person", Person.class);
		return output.getMappedResults();
	}
	
	/*
	 * GroupOperation groupByStateAndSumPop = group("state")
	 * .sum("pop").as("statePop"); MatchOperation filterStates = match(new
	 * Criteria("statePop").gt(10000000)); SortOperation sortByPopDesc =
	 * sort(Sort.by(Direction.DESC, "statePop"));
	 * 
	 * Aggregation aggregation = newAggregation( groupByStateAndSumPop,
	 * filterStates, sortByPopDesc); AggregationResults<StatePopulation> result =
	 * mongoTemplate.aggregate( aggregation, "zips", StatePopulation.class);
	 */
}
