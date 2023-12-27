package com.assignment.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductBO {
	private int productId;
	private String productName;
	private String productDesc;
	private Integer quantity;
	private double price;
}
