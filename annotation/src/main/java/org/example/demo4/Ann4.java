package org.example.demo4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wangjing
 * @date 2023/4/19
 **/
@Target(value = {
		ElementType.TYPE,
		ElementType.METHOD,
		ElementType.FIELD,
		ElementType.PARAMETER,
		ElementType.CONSTRUCTOR,
		ElementType.LOCAL_VARIABLE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ann4 {
	String value();

	ElementType elementType();
}
