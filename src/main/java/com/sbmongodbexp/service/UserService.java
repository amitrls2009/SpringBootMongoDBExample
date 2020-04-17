package com.sbmongodbexp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.sbmongodbexp.model.User;
import com.sbmongodbexp.repository.UserRepository;

@EnableMongoRepositories(basePackages = "com.sbmongodbexp.repository")
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Long saveUsers(List<User> Users) {
		for (User user : Users)
			userRepository.save(user);
		Long count = userRepository.count();
		return count;
	}

	public List<User> getAll() {
		return userRepository.findAll();

	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	public User updateUser(User userData) {
		User user = userRepository.save(userData);
		return user;

	}

	public Page<User> getPaginatedUsers(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return userRepository.findAll(paging);

	}

	public List<User> getSortedUsers(String sortedBy) {
		Sort sortOrder = Sort.by(sortedBy).descending();
		return userRepository.findAll(sortOrder);

	}

	public List<User> findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public List<User> findByUserNameIsAndTeamName(String userName, String teamName) {
		return userRepository.findByUserNameIsAndTeamName(userName, teamName);
	}

	public List<User> findByUserNameOrTeamName(String userName, String teamName) {
		return userRepository.findByUserNameOrTeamName(userName, teamName);
	}

	public List<User> findByUserIdBetween(int firstValue, int secoondValue) {
		return userRepository.findByUserIdBetween(firstValue, secoondValue);
	}

	public List<User> findByUserIdLessThan(int userId) {
		return userRepository.findByUserIdLessThan(userId);
	}

	public List<User> findByAddress(String address) {
		return userRepository.findByAddress(address);
	}

}
