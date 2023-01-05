package com.cloud.demo;

import java.math.BigDecimal;

import com.alibaba.fastjson.JSON;
import com.cloud.demo.bean.Result;
import com.cloud.demo.handler.AbstractCheckHandler;
import com.cloud.demo.handler.NullValueCheckHandler;
import com.cloud.demo.handler.PriceCheckHandler;
import com.cloud.demo.handler.StockCheckHandler;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: wangjing
 * @date 2023/1/4
 **/
public class Test {
	private static Map<String, AbstractCheckHandler> handlerMap;


	public static void main(String[] args) {
		handlerMap = new HashMap<String, AbstractCheckHandler>();
		handlerMap.put("priceCheckHandler", new PriceCheckHandler());
		handlerMap.put("nullValueCheckHandler", new NullValueCheckHandler());
		handlerMap.put("stockCheckHandler", new StockCheckHandler());
		ProductVO productVO = new ProductVO();
		productVO.setSkuId(1L);
		productVO.setSkuName("name1");
		productVO.setPath("url1");
		productVO.setPrice(new BigDecimal("100"));
		productVO.setStock(10);

		Test test = new Test();
		test.createProduct(productVO);
	}


	public Result createProduct(ProductVO param) {

		//参数校验，使用责任链模式
		Result paramCheckResult = this.paramCheck(param);
		if (!paramCheckResult.isSuccess()) {
			return paramCheckResult;
		}

		//创建商品
		return this.saveProduct(param);
	}

	/**
	 * 参数校验：责任链模式
	 *
	 * @param param
	 * @return
	 */
	private Result paramCheck(ProductVO param) {

		//获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
		ProductCheckHandlerConfig handlerConfig = this.getHandlerConfigFile();

		//获取处理器
		AbstractCheckHandler handler = this.getHandler(handlerConfig);

		//责任链：执行处理器链路
		Result executeChainResult = HandlerClient.executeChain(handler, param);
		if (!executeChainResult.isSuccess()) {
			System.out.println("创建商品 失败...");
			return executeChainResult;
		}

		//处理器链路全部成功
		return Result.success();
	}

	/**
	 * 获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
	 *
	 * @return
	 */
	private ProductCheckHandlerConfig getHandlerConfigFile() {
		//配置中心存储的配置
		String configJson = "{\"handler\":\"nullValueCheckHandler\",\"down\":false,\"next\":{\"handler\":\"priceCheckHandler\",\"next\":{\"handler\":\"stockCheckHandler\",\"next\":null}}}";
		//转成Config对象
		ProductCheckHandlerConfig handlerConfig = JSON.parseObject(configJson, ProductCheckHandlerConfig.class);
		return handlerConfig;
	}


	/**
	 * 获取处理器
	 *
	 * @param config
	 * @return
	 */
	private AbstractCheckHandler getHandler(ProductCheckHandlerConfig config) {
		//配置检查：没有配置处理器链路，则不执行校验逻辑
		if (ObjectUtils.isEmpty(config)) {
			return null;
		}
		//配置错误
		String handler = config.getHandler();
		if (StringUtils.isBlank(handler)) {
			return null;
		}
		//配置了不存在的处理器
		AbstractCheckHandler abstractCheckHandler = handlerMap.get(config.getHandler());
		if (ObjectUtils.isEmpty(abstractCheckHandler)) {
			return null;
		}

		//处理器设置配置Config
		abstractCheckHandler.setConfig(config);

		//递归设置链路处理器
		abstractCheckHandler.setNextHandler(this.getHandler(config.getNext()));

		return abstractCheckHandler;
	}


	private Result saveProduct(ProductVO param) {
		System.out.println("保存商品 成功...");
		return Result.success(param);
	}
}
