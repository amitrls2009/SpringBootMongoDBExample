package com.sbmongodbexp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "MOBILE")
public class Mobile {

	@Id
	@Field("MOBILE_ID")
	private String mobileId;
	@Field("BRAND")
	private String brand;
	@Field("SELLER")
	private String seller;
	@Field("PRICE")
	private int price;
	@Field("DISCOUNT")
	private int discount;
	@Field("FRONT_CAMERA")
	private String frontCamera;
	@Field("REAR_CAMERA")
	private String rearCamera;
	@Field("SCREEN_SIZE")
	private String screenSize;
	// Memory in GB
	@Field("MEMORY")
	private String memory;
	// Storage in GB
	@Field("STORAGE")
	private String storage;
	// Battery Size in mAH
	@Field("BATTERY")
	private String battery;
	/**
	 * @return the mobileId
	 */
	public String getMobileId() {
		return mobileId;
	}
	/**
	 * @param mobileId the mobileId to set
	 */
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the seller
	 */
	public String getSeller() {
		return seller;
	}
	/**
	 * @param seller the seller to set
	 */
	public void setSeller(String seller) {
		this.seller = seller;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the discount
	 */
	public int getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	/**
	 * @return the frontCamera
	 */
	public String getFrontCamera() {
		return frontCamera;
	}
	/**
	 * @param frontCamera the frontCamera to set
	 */
	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}
	/**
	 * @return the rearCamera
	 */
	public String getRearCamera() {
		return rearCamera;
	}
	/**
	 * @param rearCamera the rearCamera to set
	 */
	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}
	/**
	 * @return the screenSize
	 */
	public String getScreenSize() {
		return screenSize;
	}
	/**
	 * @param screenSize the screenSize to set
	 */
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	/**
	 * @return the memory
	 */
	public String getMemory() {
		return memory;
	}
	/**
	 * @param memory the memory to set
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}
	/**
	 * @return the storage
	 */
	public String getStorage() {
		return storage;
	}
	/**
	 * @param storage the storage to set
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}
	/**
	 * @return the battery
	 */
	public String getBattery() {
		return battery;
	}
	/**
	 * @param battery the battery to set
	 */
	public void setBattery(String battery) {
		this.battery = battery;
	}
	/**
	 * @param mobileId
	 * @param brand
	 * @param seller
	 * @param price
	 * @param discount
	 * @param frontCamera
	 * @param rearCamera
	 * @param screenSize
	 * @param memory
	 * @param storage
	 * @param battery
	 */
	public Mobile(String mobileId, String brand, String seller, int price, int discount, String frontCamera,
			String rearCamera, String screenSize, String memory, String storage, String battery) {
		super();
		this.mobileId = mobileId;
		this.brand = brand;
		this.seller = seller;
		this.price = price;
		this.discount = discount;
		this.frontCamera = frontCamera;
		this.rearCamera = rearCamera;
		this.screenSize = screenSize;
		this.memory = memory;
		this.storage = storage;
		this.battery = battery;
	}
	/**
	 * 
	 */
	public Mobile() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", brand=" + brand + ", seller=" + seller + ", price=" + price
				+ ", discount=" + discount + ", frontCamera=" + frontCamera + ", rearCamera=" + rearCamera
				+ ", screenSize=" + screenSize + ", memory=" + memory + ", storage=" + storage + ", battery=" + battery
				+ "]";
	}

	

}
