package com.young.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String name;
	private int del;

	public UserEntity() {
		super();
	}

	public UserEntity(String name) {
		super();
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nUserEntity{" +
				"userId=" + userId +
				", name='" + name + '\'' +
				'}';
	}
}