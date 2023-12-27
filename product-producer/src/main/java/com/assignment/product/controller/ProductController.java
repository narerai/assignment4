package com.assignment.product.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.product.controller.config.MessagingConfig;
import com.assignment.product.dto.ProductBO;
import com.assignment.product.dto.ProductStatus;
import com.assignment.product.services.ProductService;




@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
    private RabbitTemplate template;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
    public String bookOrder(@RequestBody ProductBO product) {
		//product.setProductId(UUID.randomUUID().toString());
        ProductStatus productStatus = new ProductStatus(product, "PROCESS", "Product Quaed for succesfully in " );
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, productStatus);
        return "Successfully processed for save Product !!";
    }
	
	@GetMapping
	public List<ProductBO> getAllProduct(){
		return productService.getAllProduct();
	}
	
	

}
