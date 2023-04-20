package org.example.demo5;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * @author: wangjing
 * @date 2023/4/19
 **/
public class UserTYPE_PARAMETER<@Ann5("T0泛型类型变量") T0, @Ann5("T1泛型类型变量") T1> {

	public <@Ann5("T2方法上泛型类型变量") T2> void m1() {

	}

	public static void main(String[] args) throws NoSuchMethodException {
		for (TypeVariable<Class<UserTYPE_PARAMETER>> typeParameter : UserTYPE_PARAMETER.class.getTypeParameters()) {
			print(typeParameter);
		}

		for (TypeVariable<Method> m1 : UserTYPE_PARAMETER.class.getDeclaredMethod("m1").getTypeParameters()) {
			print(m1);
		}
		
	}

	private static void print(TypeVariable typeVariable) {
		System.out.println("类型变量名称:" + typeVariable.getName());
		Arrays.stream(typeVariable.getAnnotations()).forEach(System.out::println);
	}
}
