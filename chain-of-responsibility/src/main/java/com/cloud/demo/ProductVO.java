package com.cloud.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: wangjing
 * @date 2023/1/3
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	/**
	 * 商品SKU，唯一
	 */
	private Long skuId;
	/**
	 * 商品名称
	 */
	private String skuName;
	/**
	 * 商品图片路径
	 */
	private String Path;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 库存
	 */
	private Integer stock;
}
