package com.sbmongodbexp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbmongodbexp.model.Mobile;
import com.sbmongodbexp.service.MobileService;

@RestController
@RequestMapping("/mobiles")
public class MobileController {

	@Autowired
	MobileService mobileService;

	@PostMapping
	ResponseEntity<Integer> saveMobile(@RequestBody List<Mobile> mobiles) {

		int count = mobileService.saveMobile(mobiles);
		HttpHeaders httpHeaders = new HttpHeaders();
		ResponseEntity responseEntity = null;
		if (count != 0) {
			httpHeaders.add("Success", "Mobile added successfully");
			responseEntity = new ResponseEntity<>(count, httpHeaders, HttpStatus.CREATED);
		} else {
			httpHeaders.add("Failure", "Mobile has not been added successfully");
			responseEntity = ResponseEntity.badRequest().header("Failure", "Mobile not saved").body(null);
		}
		return responseEntity;
	}

	@GetMapping
	ResponseEntity<List<Mobile>> getAllMobiles() {
		ResponseEntity<List<Mobile>> responseEnitity = null;
		List<Mobile> mobiles = mobileService.getAllMobiles();
		return responseEnitity.ok().body(mobiles);
	}
}
