package com.cloud.demo1;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class ConcreteHandler1 extends Handler {
	public void handleRequest(int request) {
		if (request > 0 && request <= 10) {
			System.out.println("ConcreteHandler1 handled request " + request);
		} else if (successor != null) {
			successor.handleRequest(request);
		}
	}
}
