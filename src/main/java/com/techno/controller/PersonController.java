package com.techno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techno.model.Person;
import com.techno.service.PersonService;

@RestController
@RequestMapping("/api/mongodbperson")
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping("/addPerson")
	ResponseEntity<Long> addPerson(@RequestBody List<Person> persons) {
		Long count = personService.savePerson(persons);
		HttpHeaders httpHeaders = new HttpHeaders();
		ResponseEntity responseEntity = null;
		if (count != null) {
			httpHeaders.add("Success", "All Users Saved Successfully");
			responseEntity = new ResponseEntity<>(count, httpHeaders, HttpStatus.OK);
		} else {
			httpHeaders.add("Failure", "All User Not Saved Successfully");
			responseEntity = ResponseEntity.badRequest().header("Failuer", "User Not saved").body(null);
		}
		return responseEntity;
	}

	@GetMapping("/getPersons")
	ResponseEntity<List<Person>> getAllPerson() {
		List<Person> persons = personService.getAllPerson();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@DeleteMapping("/deletePerson")
	ResponseEntity<String> deletePerson(@RequestBody Person person) {
		personService.deletePerson(person);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Success", "Person has been deleted Successfully");
		return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
	}

	@PutMapping("/updatePersonAddressById")
	ResponseEntity<String> updatePersonAddressById(@RequestBody Person person) {
		Person pers = personService.updatePersonAddressById(person);
		HttpHeaders httpHeaders = new HttpHeaders();
		ResponseEntity responseEntity = null;
		if (pers != null) {
			httpHeaders.add("Success", "Person has been updated Successfully");
			responseEntity = new ResponseEntity<>(pers, httpHeaders, HttpStatus.OK);
		} else {
			httpHeaders.add("Failure", "All User Not Saved Successfully");
			responseEntity = ResponseEntity.badRequest().header("Failuer", "Person not updated").body(null);
		}
		return responseEntity;
	}

	// Need to check.Working only for first record
	@PutMapping("/updateMultiplePersonAgeByOne")
	ResponseEntity<String> updateMultiplePersonAge() {
		personService.updateMultiplePersonAge();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Success", "Person's age have been updated Successfully");
		return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
	}

	@GetMapping("/getPersonsByFavoriteBooks")
	public ResponseEntity<List<Person>> findByFavoriteBooks(@RequestParam List<String> favoriteBooks) {
		List<Person> persons = personService.findByFavoriteBooks(favoriteBooks);
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@GetMapping("/getPersonsByAgeRange")
	public ResponseEntity<List<Person>> findByAgeRange(@RequestParam int lowerBound, @RequestParam int upperBound) {
		List<Person> persons = personService.findByAgeRange(lowerBound, upperBound);
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@GetMapping("/getPersonsByName")
	public ResponseEntity<List<Person>> findByName(@RequestParam String name) {
		List<Person> persons = personService.findByName(name);
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@GetMapping("/getPersonsWithPagination")
	public List<Person> getAllPersonPaginated(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return personService.getAllPersonPaginated(pageNumber, pageSize);
	}

}
