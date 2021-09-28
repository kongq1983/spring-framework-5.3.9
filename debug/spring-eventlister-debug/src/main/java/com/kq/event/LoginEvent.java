package com.kq.event;

import java.util.Date;

/**
 * @author kq
 * @date 2021-09-28 10:20
 * @since 2020-0630
 */
public class LoginEvent {

	private Long id;
	private Date loginTime;

	public LoginEvent(Long id,Date loginTime) {
		this.id = id;
		this.loginTime = loginTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "LoginEvent{" +
				"id=" + id +
				", loginTime=" + loginTime +
				'}';
	}
}
