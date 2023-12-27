package com.assignment.product.consumer;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.product.config.MessagingConfig;
import com.assignment.product.dto.ProductBO;
import com.assignment.product.dto.ProductStatus;
import com.assignment.product.entity.ProductEntity;
import com.assignment.product.repository.ProductRepository;

@Component
public class ProductConsumer {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ModelMapper modelMapper;

	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(ProductStatus productStatus) {
		System.out.println("Message recieved from queue : " + productStatus);
		ProductEntity entity = new ProductEntity();
		// modelMapper.map(productStatus.getOrder(), ProductEntity.class);
		entity.setPrice(productStatus.getOrder().getPrice());
		entity.setProductDesc(productStatus.getOrder().getProductDesc());
		entity.setProductName(productStatus.getOrder().getProductName());
		entity.setQuantity(productStatus.getOrder().getQuantity());
		System.out.println(entity);
		productRepository.save(entity);

	}
}
