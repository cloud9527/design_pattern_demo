package com.cloud.demo3;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class HR extends LeaveApprover {
	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getDays() <= 30) {
			System.out.println("HR approved " + request);
		} else {
			System.out.println("Leave request not approved: " + request);
		}
	}
}
