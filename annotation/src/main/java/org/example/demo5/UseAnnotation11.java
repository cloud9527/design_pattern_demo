package org.example.demo5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wangjing
 * @date 2023/4/19
 **/


@Target({ElementType.PACKAGE,
		ElementType.TYPE,
		ElementType.FIELD,
		ElementType.CONSTRUCTOR,
		ElementType.METHOD,
		ElementType.PARAMETER,
		ElementType.TYPE_PARAMETER,
		ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@interface Ann11 {
	String value();
}

@Target({ElementType.PACKAGE,
		ElementType.TYPE,
		ElementType.FIELD,
		ElementType.CONSTRUCTOR,
		ElementType.METHOD,
		ElementType.PARAMETER,
		ElementType.TYPE_PARAMETER,
		ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@interface Ann11_0 {
	int value();
}


public class UseAnnotation11 {
}
