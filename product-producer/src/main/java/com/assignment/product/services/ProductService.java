package com.assignment.product.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.product.dto.ProductBO;
import com.assignment.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<ProductBO> getAllProduct(){
		//List<ProductEntity> listOfProduct=productRepository.findAll();
		return productRepository.findAll().stream().map(post -> modelMapper.map(post, ProductBO.class))
				.collect(Collectors.toList());
		
	}

}
