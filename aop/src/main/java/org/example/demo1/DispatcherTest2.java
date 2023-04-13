package org.example.demo1;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wangjing
 * @date 2023/4/13
 **/
public class DispatcherTest2 {
	public static class UserService {
		public void add() {
			System.out.println("新增用户");
		}

		public void update() {
			System.out.println("更新用户信息");
		}
	}

	//用来获取方法信息的接口
	public interface IMethodInfo {
		//获取方法数量
		int methodCount();

		//获取被代理的对象中方法名称列表
		List<String> methodNames();
	}

	public static class DefaultMethodInfo implements IMethodInfo {
		private Class<?> targetClass;

		public DefaultMethodInfo(Class<?> targetClass) {
			this.targetClass = targetClass;
		}

		@Override
		public int methodCount() {
			return targetClass.getDeclaredMethods().length;
		}

		@Override
		public List<String> methodNames() {
			return Arrays.stream(targetClass.getDeclaredMethods()).
					map(Method::getName).
					collect(Collectors.toList());
		}
		
	}

	public static void main(String[] args) {
		Class<?> targetClass = UserService.class;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClass);
		enhancer.setInterfaces(new Class[]{IMethodInfo.class});
		//创建一个方法统计器
		DefaultMethodInfo methodInfo = new DefaultMethodInfo(targetClass);
		//创建会调用器列表，此处定义了2个，第1个用于处理UserService中所有的方法，第2个用来处理IMethodInfo接口中的方法
		Callback[] callbacks = {
				(MethodInterceptor) (o, method, objects, methodProxy) -> {
					return methodProxy.invokeSuper(o,objects);
				},
				(Dispatcher) () -> methodInfo
		};
		enhancer.setCallbacks(callbacks);
		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				return method.getDeclaringClass() == IMethodInfo.class ? 1 : 0;
			}
		});

		Object proxy = enhancer.create();
		//代理的父类是UserService
		UserService userService = (UserService) proxy;
		userService.add();
		//代理实现了IMethodInfo接口
		IMethodInfo mf = (IMethodInfo) proxy;
		System.out.println(mf.methodCount());
		System.out.println(mf.methodNames());
	}

}
