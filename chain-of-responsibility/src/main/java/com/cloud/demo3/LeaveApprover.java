package com.cloud.demo3;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public abstract class LeaveApprover {
	protected LeaveApprover successor;
	public void setSuccessor(LeaveApprover successor) {
		this.successor = successor;
	}
	public abstract void handleRequest(LeaveRequest request);
}
