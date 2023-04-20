package org.example.demo4;

import java.lang.annotation.ElementType;

/**
 * @author: wangjing
 * @date 2023/4/19
 **/
@Ann4(value = "213", elementType = ElementType.TYPE)
public class UserAnn4 {

	@Ann4(value = "我用在字段上", elementType = ElementType.FIELD)
	private String a;

	@Ann4(value = "我用在构造方法上", elementType = ElementType.CONSTRUCTOR)
	public UserAnn4(@Ann4(value = "我用在方法参数上", elementType = ElementType.PARAMETER) String a) {
		this.a = a;
	}

	@Ann4(value = "我用在了普通方法上面", elementType = ElementType.METHOD)
	public void m1() {
		@Ann4(value = "我用在了本地变量上", elementType = ElementType.LOCAL_VARIABLE) String a;
	}
}
