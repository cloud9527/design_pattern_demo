package com.cloud.demo3;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class LeaveRequest {
	private String employeeName;
	private int days;
	private String reason;
	public LeaveRequest(String employeeName, int days, String reason) {
		this.employeeName = employeeName;
		this.days = days;
		this.reason = reason;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public int getDays() {
		return days;
	}
	public String getReason() {
		return reason;
	}
	@Override
	public String toString() {
		return "LeaveRequest{" +
				"employeeName='" + employeeName + '\'' +
				", days=" + days +
				", reason='" + reason + '\'' +
				'}';
	}
}
