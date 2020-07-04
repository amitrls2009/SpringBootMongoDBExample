package com.techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techno.model.Mobile;
import com.techno.repository.MobileRepository;

@Service
public class MobileService {

	@Autowired
	MobileRepository mobileRepository;

	public int saveMobile(List<Mobile> mobiles) {

		System.out.println("Before Calling Save :");
		int mobileCountBeforeAdding = getAllMobiles().size();
		mobileRepository.saveAll(mobiles);
		System.out.println("After Calling Save :");
		int mobileCountAfterAdding = getAllMobiles().size();
		return (mobileCountAfterAdding - mobileCountBeforeAdding);

	}

	public List<Mobile> getAllMobiles() {
		return mobileRepository.findAll();
	}
}
