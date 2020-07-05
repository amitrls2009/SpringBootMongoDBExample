package com.techno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.model.Mobile;
import com.techno.service.MobileService;

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

	@PutMapping
	ResponseEntity<String> updateMobile(@RequestBody Mobile mobile) {

		ResponseEntity<String> responseEntity = null;

		String mobileId = mobileService.updateMobile(mobile);
		if (mobileId != null) {
			responseEntity = new ResponseEntity<>(mobileId + "has been updated", HttpStatus.OK);
		} else {
			String msg = mobileId + "Mobile has not been updated";
			responseEntity = ResponseEntity.badRequest().header("Failure", "Mobile information has not been updated")
					.body(null);
		}

		return responseEntity;
	}

	@GetMapping("/{mobileId}")
	ResponseEntity<Mobile> getMobile(@PathVariable String mobileId) {
		System.out.println("mobileId :-" + mobileId);
		Mobile mobile = mobileService.getMobile(mobileId);
		return new ResponseEntity<Mobile>(mobile, HttpStatus.OK);
	}

	@GetMapping("/greaterthanequal/{price}")
	ResponseEntity<List<Mobile>> getMobileByPrice(@PathVariable int price) {
		System.out.println("price :-" + price);
		List<Mobile> mobileList = mobileService.getMobileByPrice(price);
		return new ResponseEntity<List<Mobile>>(mobileList, HttpStatus.OK);
	}
}
