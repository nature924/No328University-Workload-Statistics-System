package com.hdc.entity;

import java.io.Serializable;

public class AuthoritiesEntity implements Serializable {

	private static final long serialVersionUID = 8973231995649292943L;
	private Integer authorityId;
	private Integer userId;
	private String authorities;

	/**
	 * @return the authorityId
	 */
	public Integer getAuthorityId() {
		return authorityId;
	}

	/**
	 * @param authorityId
	 *            the authorityId to set
	 */
	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the authorities
	 */
	public String getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities
	 *            the authorities to set
	 */
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public AuthoritiesEntity() {
		super();
	}

	public AuthoritiesEntity(Integer userId, String authorities) {
		super();
		this.userId=userId;
		this.authorities=authorities;
	}

}
