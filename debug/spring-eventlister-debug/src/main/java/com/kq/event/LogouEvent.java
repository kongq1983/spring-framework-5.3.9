package com.kq.event;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * @author kq
 * @date 2021-09-28 14:57
 * @since 2020-0630
 */
public class LogouEvent extends ApplicationEvent {

	private static final long serialVersionUID = 5679663433534870442L;

	private Long id;
	private Date logoutTime;

	public LogouEvent(Long id,Date logoutTime,Object source) {
		super(source);
		this.id = id;
		this.logoutTime = logoutTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	@Override
	public String toString() {
		return "LogouEvent{" +
				"id=" + id +
				", logoutTime=" + logoutTime +
				", source=" + source +
				'}';
	}
}
