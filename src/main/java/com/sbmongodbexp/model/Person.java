package com.sbmongodbexp.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
    
	@Id
	private int personId;
	/**
	 * @param personId
	 * @param personName
	 * @param address
	 * @param age
	 * @param favoriteBooks
	 */
	public Person(int personId, String personName, String address, int age, List<String> favoriteBooks) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.address = address;
		this.age = age;
		this.favoriteBooks = favoriteBooks;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", address=" + address + ", age=" + age
				+ ", favoriteBooks=" + favoriteBooks + "]";
	}
	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the favoriteBooks
	 */
	public List<String> getFavoriteBooks() {
		return favoriteBooks;
	}
	/**
	 * @param favoriteBooks the favoriteBooks to set
	 */
	public void setFavoriteBooks(List<String> favoriteBooks) {
		this.favoriteBooks = favoriteBooks;
	}
	private String personName;
	private String address;
	private int age;
	private List<String> favoriteBooks;
}
