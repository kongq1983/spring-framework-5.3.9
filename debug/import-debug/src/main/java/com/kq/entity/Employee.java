package com.kq.entity;


import java.util.Date;

/**
 * @author kq
 * @date 2020-11-11 11:04
 * @since 2020-0630
 */
public class Employee {

    private Long id;
    private Date birythDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirythDate() {
		return birythDate;
	}

	public void setBirythDate(Date birythDate) {
		this.birythDate = birythDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", birythDate=" + birythDate +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", hireDate=" + hireDate +
				'}';
	}
}
