package com.assignment.product.util;

import com.assignment.product.dto.ProductBO;
import com.assignment.product.entity.ProductEntity;

public class ConverterUtil {
	
	public static ProductEntity convertBoToEntity(ProductBO productBo) {
		
		ProductEntity pe=new ProductEntity();
		pe.setPrice(productBo.getPrice());
		pe.setProductDesc(productBo.getProductDesc());
		pe.setProductName(productBo.getProductName());
		pe.setQuantity(productBo.getQuantity());
		return pe;
	
	}
	
	public static ProductBO convertEntityToBo(ProductEntity productBo) {
		
		ProductBO pe=new ProductBO();
		pe.setPrice(productBo.getPrice());
		pe.setProductDesc(productBo.getProductDesc());
		pe.setProductName(productBo.getProductName());
		pe.setQuantity(productBo.getQuantity());
		return pe;
	
	}


}
