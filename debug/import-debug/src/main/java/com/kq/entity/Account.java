package com.kq.entity;

import java.util.Date;

/**
 * @author kq
 * @date 2021-09-14 9:43
 * @since 2020-0630
 */
public class Account {

	private Long id;
	private String username;
	private String phone;
	private String province;
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", username='" + username + '\'' +
				", phone='" + phone + '\'' +
				", province='" + province + '\'' +
				", createTime=" + createTime +
				'}';
	}
}
