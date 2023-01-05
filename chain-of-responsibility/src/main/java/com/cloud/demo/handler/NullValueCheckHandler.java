package com.cloud.demo.handler;


import com.cloud.demo.bean.ErrorCode;
import com.cloud.demo.ProductVO;
import com.cloud.demo.bean.Result;
import org.apache.commons.lang3.ObjectUtils;


/**
 * 空值校验处理器
 */
public class NullValueCheckHandler extends AbstractCheckHandler {

	@Override
	public Result handle(ProductVO param) {
		System.out.println("空值校验 Handler 开始...");

		//降级：如果配置了降级，则跳过此处理器，执行下一个处理器
		if (super.getConfig().getDown()) {
			System.out.println("空值校验 Handler 已降级，跳过空值校验 Handler...");
			return super.next(param);
		}

		//参数必填校验
		if (ObjectUtils.isEmpty(param)) {
			return Result.failure(ErrorCode.PARAM_NULL_ERROR);
		}
		//SkuId商品主键参数必填校验
		if (ObjectUtils.isEmpty(param.getSkuId())) {
			return Result.failure(ErrorCode.PARAM_SKU_NULL_ERROR);
		}
		//Price价格参数必填校验
		if (ObjectUtils.isEmpty(param.getPrice())) {
			return Result.failure(ErrorCode.PARAM_PRICE_NULL_ERROR);
		}
		//Stock库存参数必填校验
		if (ObjectUtils.isEmpty(param.getStock())) {
			return Result.failure(ErrorCode.PARAM_STOCK_NULL_ERROR);
		}

		System.out.println("空值校验 Handler 通过...");

		//执行下一个处理器
		return super.next(param);
	}
}
