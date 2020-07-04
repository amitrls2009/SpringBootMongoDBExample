package com.techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.model.Person;
import com.techno.repository.PersonDAL;

@Service
public class PersonService {

	@Autowired
	PersonDAL personDAL;

	public long savePerson(List<Person> persons) {
		for (Person person : persons)
			personDAL.savePerson(person);
		return personDAL.countPerson();
	}

	public List<Person> getAllPerson() {
		return personDAL.getAllPerson();
	}

	public void deletePerson(Person person) {
		personDAL.deletePerson(person);
	}

	public Person updatePersonAddressById(Person person) {
		return personDAL.updatePersonAddressById(person);
	}

	public void updateMultiplePersonAge() {
		personDAL.updateMultiplePersonAge();
	}

	public List<Person> findByFavoriteBooks(List<String> favoriteBooks) {
		return personDAL.findByFavoriteBooks(favoriteBooks);
	}

	public List<Person> findByAgeRange(int lowerBound, int upperBound) {
		return personDAL.findByAgeRange(lowerBound, upperBound);
	}

	public List<Person> findByName(String name) {
		return personDAL.findByName(name);
	}

	public List<Person> getAllPersonPaginated(int pageNumber, int pageSize) {
		return personDAL.getAllPersonPaginated(pageNumber, pageSize);
	}

}
