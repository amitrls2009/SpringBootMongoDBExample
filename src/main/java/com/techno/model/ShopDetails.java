package com.techno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SHOPDETAILS")
public class ShopDetails {

	@Id
	private int shopId;
	/**
	 * @return the shopId
	 */
	public int getShopId() {
		return shopId;
	}
	/**
	 * @param shopId the shopId to set
	 */
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * @return the shopLocation
	 */
	public String getShopLocation() {
		return shopLocation;
	}
	/**
	 * @param shopId
	 * @param shopName
	 * @param shopLocation
	 */
	public ShopDetails(int shopId, String shopName, String shopLocation) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopLocation = shopLocation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShopDetails [shopId=" + shopId + ", shopName=" + shopName + ", shopLocation=" + shopLocation + "]";
	}
	/**
	 * @param shopLocation the shopLocation to set
	 */
	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}
	private String shopName;
	private String shopLocation;
	
	
}
