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

	public String updateMobile(Mobile mobile) {

		Mobile mobData = null;

		mobData = mobileRepository.findByMobileId(mobile.getMobileId());
		mobData.setBattery(mobile.getBattery());
		mobData.setBrand(mobile.getBrand());
		mobData.setDiscount(mobile.getDiscount());
		mobData.setFrontCamera(mobile.getFrontCamera());
		mobData.setMemory(mobile.getMemory());
		mobData.setPrice(mobile.getPrice());
		mobData.setRearCamera(mobile.getRearCamera());
		mobData.setScreenSize(mobile.getScreenSize());
		mobData.setSeller(mobile.getSeller());
		mobData.setStorage(mobile.getStorage());

		mobData = mobileRepository.save(mobData);

		return mobData.getMobileId();
	}

	public Mobile getMobile(String mobileId) {
		Mobile mobile = mobileRepository.findByMobileId(mobileId);
		return mobile;
	}

	public List<Mobile> getMobileByPrice(int price) {
		List<Mobile> mobileList = mobileRepository.findByPriceGreaterThanEqual(price);
		return mobileList;
	}
}
