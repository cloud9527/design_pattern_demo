package com.cloud.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: wangjing
 * @date 2023/1/3
 **/
@AllArgsConstructor
@Data
public class ProductCheckHandlerConfig {
	/**
	 * 处理器Bean名称
	 */
	private String handler;
	/**
	 * 下一个处理器
	 */
	private ProductCheckHandlerConfig next;
	/**
	 * 是否降级
	 */
	private Boolean down = Boolean.FALSE;
}
