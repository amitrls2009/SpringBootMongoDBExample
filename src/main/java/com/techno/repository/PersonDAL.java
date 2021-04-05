package com.techno.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techno.model.Person;


public interface PersonDAL {
	Person savePerson(Person person);

	List<Person> getAllPerson();

	List<Person> getAllPersonPaginated(int pageNumber, int pageSize);

	Person findOneByName(String name);

	List<Person> findByName(String name);

	List<Person> findByAgeRange(int lowerBound, int upperBound);

	List<Person> findByFavoriteBooks(List<String> favoriteBook);

	void updateMultiplePersonAge();

	Person updatePersonAddressById(Person person);

	void deletePerson(Person person);
	
	long countPerson();

	List<Person> getAllPersonProjected();

	List<Person> getAllPersonAggregated();

}
