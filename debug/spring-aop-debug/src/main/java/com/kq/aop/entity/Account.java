package com.kq.aop.entity;

/**
 * @author kq
 * @date 2021-09-24 10:03
 * @since 2020-0630
 */
public class Account {

	private int id;
	private String name;
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
