package com.sbmongodbexp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sbmongodbexp.model.User;
import com.sbmongodbexp.service.UserService;

@RestController
@RequestMapping("/api/mongodbuser")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/getAllUsers")
	ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getPaginatedUsers")
	ResponseEntity<Page<User>> getPaginatedUsers(@RequestParam int pageNo, @RequestParam int pageSize) {
		Page<User> users = userService.getPaginatedUsers(pageNo, pageSize);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getSortedUsers/{sortedBy}")
	ResponseEntity<List<User>> getSortedUsers(@PathVariable String sortedBy) {
		List<User> users = userService.getSortedUsers(sortedBy);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByUserName/{Name}")
	ResponseEntity<List<User>> findByUserName(@PathVariable String Name) {
		List<User> users = userService.findByUserName(Name);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByUserNameAndTeamName")
	ResponseEntity<List<User>> findByUserNameIsAndTeamName(@RequestParam String userName,@RequestParam String teamName) {
		List<User> users = userService.findByUserNameIsAndTeamName(userName,teamName);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByUserNameOrTeamName")
	ResponseEntity<List<User>> findByUserNameOrTeamName(@RequestParam String userName,@RequestParam String teamName) {
		List<User> users = userService.findByUserNameOrTeamName(userName,teamName);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByUserIdBetween")
	ResponseEntity<List<User>> findByUserIdBetween(@RequestParam Integer firstValue,@RequestParam Integer secoondValue) {
		List<User> users = userService.findByUserIdBetween(firstValue,secoondValue);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByUserIdLessThan")
	ResponseEntity<List<User>> findByUserIdLessThan(@RequestParam Integer userId) {
		List<User> users = userService.findByUserIdLessThan(userId);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/getUserByAddress")
	ResponseEntity<List<User>> findByAddress(@RequestParam String address) {
		List<User> users = userService.findByAddress(address);
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}


	@PostMapping("/addUser")
	ResponseEntity<Long> addUsers(@RequestBody List<User> Users) {
		Long count = userService.saveUsers(Users);
		HttpHeaders httpHeaders = new HttpHeaders();
		ResponseEntity responseEntity = null;
		if (count != 0) {
			httpHeaders.add("Success", "All Users Saved Successfully");
			responseEntity = new ResponseEntity<>(count, httpHeaders, HttpStatus.OK);
		} else {
			httpHeaders.add("Failure", "All User Not Saved Successfully");
			responseEntity = ResponseEntity.badRequest().header("Failuer", "User Not saved").body(null);
		}
		return responseEntity;
	}

	@DeleteMapping("/deleteUser/{userId}")
	ResponseEntity<String> deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Success", "Users Deleted Successfully");
		return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
	}

	@PutMapping("/updateUser")
	ResponseEntity<User> updateUser(@RequestBody User User) {
		User updatedUser = userService.updateUser(User);
		HttpHeaders httpHeaders = new HttpHeaders();
		ResponseEntity responseEntity = null;
		if (updatedUser != null) {
			httpHeaders.add("Success", "User updated Successfully");
			responseEntity = new ResponseEntity<>(updatedUser, httpHeaders, HttpStatus.OK);
		} else {
			responseEntity = ResponseEntity.badRequest().header("Failuer", "User Not Updated").body(null);
		}
		return responseEntity;
	}

}
