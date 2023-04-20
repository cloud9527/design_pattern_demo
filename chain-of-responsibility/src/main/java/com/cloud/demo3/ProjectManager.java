package com.cloud.demo3;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class ProjectManager extends LeaveApprover {
	@Override
	public void handleRequest(LeaveRequest request) {
		if (request.getDays() <= 7) {
			System.out.println("ProjectManager approved " + request);
		} else if (successor != null) {
			successor.handleRequest(request);
		}
	}
}
