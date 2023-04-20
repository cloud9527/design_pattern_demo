package com.cloud.demo1;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class Client {
	public static void main(String[] args) {
		// 创建具体处理者对象
		Handler handler1 = new ConcreteHandler1();
		Handler handler2 = new ConcreteHandler2();
		// 设置处理者顺序
		handler1.setSuccessor(handler2);
		// 发送请求
		int[] requests = {2, 5, 12, 18, 25};
		for (int request : requests) {
			handler1.handleRequest(request);
		}

		
	}
}
