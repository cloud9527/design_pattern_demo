package com.cloud.demo3;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class Client {
	public static void main(String[] args) {
		// 创建具体处理者对象
		LeaveApprover teamLeader = new TeamLeader();
		LeaveApprover projectManager = new ProjectManager();
		LeaveApprover hr = new HR();
		// 设置处理者顺序
		teamLeader.setSuccessor(projectManager);
		projectManager.setSuccessor(hr);
		// 发送请假请求
		LeaveRequest request1 = new LeaveRequest("Alice", 2, "Sick leave");
		LeaveRequest request2 = new LeaveRequest("Bob", 5, "Vacation");
		LeaveRequest request3 = new LeaveRequest("Charlie", 12, "Family emergency");
		LeaveRequest request4 = new LeaveRequest("David", 35, "Long vacation");
		teamLeader.handleRequest(request1);
		teamLeader.handleRequest(request2);
		teamLeader.handleRequest(request3);
		teamLeader.handleRequest(request4);
	}
	
}
