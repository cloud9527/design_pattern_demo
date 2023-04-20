package com.cloud.demo3;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class TeamLeader extends LeaveApprover {
	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getDays() <= 3) {
			System.out.println("TeamLeader approved " + request);
		} else if (successor != null) {
			successor.handleRequest(request);
		}
	}
}
