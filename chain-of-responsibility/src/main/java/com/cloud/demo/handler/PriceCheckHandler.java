package com.cloud.demo.handler;


import com.cloud.demo.bean.ErrorCode;
import com.cloud.demo.ProductVO;
import com.cloud.demo.bean.Result;

import java.math.BigDecimal;

/**
 * 价格校验处理器
 */
public class PriceCheckHandler extends AbstractCheckHandler {
	@Override
	public Result handle(ProductVO param) {
		System.out.println("价格校验 Handler 开始...");

		//非法价格校验
		boolean illegalPrice = param.getPrice().compareTo(BigDecimal.ZERO) <= 0;
		if (illegalPrice) {
			return Result.failure(ErrorCode.PARAM_PRICE_ILLEGAL_ERROR);
		}
		//其他校验逻辑...

		System.out.println("价格校验 Handler 通过...");

		//执行下一个处理器
		return super.next(param);
	}
}
