package com.cloud.demo1;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public class ConcreteHandler2 extends Handler {
	public void handleRequest(int request) {
		if (request > 10 && request <= 20) {
			System.out.println("ConcreteHandler2 handled request " + request);
		} else if (successor != null) {
			successor.handleRequest(request);
		}
	}
}
