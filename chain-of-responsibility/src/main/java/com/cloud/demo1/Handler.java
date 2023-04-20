package com.cloud.demo1;

/**
 * @author: wangjing
 * @date 2023/4/20
 **/
public abstract class Handler {
	protected Handler successor;
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	public abstract void handleRequest(int request);
}
