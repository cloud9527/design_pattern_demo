package org.example.demo1;

import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;

import java.util.UUID;

/**
 * @author: wangjing
 * @date 2023/4/13
 **/
public class DispatcherTest1 {
	public static class UserModel {
		private String name;

		public UserModel() {
		}

		public UserModel(String name) {
			this.name = name;
		}

		public void say() {
			System.out.println("你好：" + name);
		}
	}

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(LazyLoaderTest1.UserModel.class);
		Dispatcher dispatcher = new Dispatcher() {
			@Override
			public Object loadObject() throws Exception {
				System.out.println("调用Dispatcher.loadObject()方法");
				return new LazyLoaderTest1.UserModel("陈某java," + UUID.randomUUID().toString());
			}
		};
		enhancer.setCallback(dispatcher);
		Object proxy = enhancer.create();
		LazyLoaderTest1.UserModel userModel = (LazyLoaderTest1.UserModel) proxy;
		System.out.println("第1次调用say方法");
		userModel.say();
		System.out.println("第1次调用say方法");
		userModel.say();

	}
}
