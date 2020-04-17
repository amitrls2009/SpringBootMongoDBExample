package com.sbmongodbexp.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("USERS")
public class User {
    
	@Id
	@Field("USER_ID")
	private int userId;
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
	@Field("USER_NAME")
	private String userName;
	@Field("TEAM_NAME")
	private String teamName;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", teamName=" + teamName + ", address=" + address
				+ "]";
	}
	/**
	 * @param userId
	 * @param userName
	 * @param teamName
	 * @param address
	 */
	public User(int userId, String userName, String teamName, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.teamName = teamName;
		this.address = address;
	}
	/**
	 * 
	 */
	public User() {
		super();
	}
	@Field("ADDRESS")
	private String address;
}
