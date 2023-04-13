package org.example.demo1;

/**
 * @author: wangjing
 * @date 2023/4/13
 **/

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

/**
 * cglib懒加载
 */
public class LazyLoaderTest1 {
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
		enhancer.setSuperclass(UserModel.class);
		LazyLoader lazyLoader = new LazyLoader() {
			@Override
			public Object loadObject() throws Exception {
				System.out.println("调用LazyLoader.loadObject()方法");
				return new UserModel("hi--java");
			}
		};
		enhancer.setCallback(lazyLoader);
		Object proxy = enhancer.create();
		UserModel userModel = (UserModel) proxy;
		System.out.println("第1次调用say方法");
		userModel.say();
		System.out.println("第1次调用say方法");
		userModel.say();
	}
}
