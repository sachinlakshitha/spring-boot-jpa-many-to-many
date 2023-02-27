package com.sachinlakshitha.springbootjpamanytomany;

import com.sachinlakshitha.springbootjpamanytomany.dto.OrdersDto;
import com.sachinlakshitha.springbootjpamanytomany.dto.ProductDto;
import com.sachinlakshitha.springbootjpamanytomany.service.OrdersService;
import com.sachinlakshitha.springbootjpamanytomany.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class SpringBootJpaManyToManyApplication implements CommandLineRunner {
	private ProductService productService;
	private OrdersService ordersService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("[SAVE]");
		ProductDto product1 = new ProductDto();
		product1.setId(UUID.randomUUID().toString());
		product1.setName("Product 1");
		product1.setUnitPrice(100.00);

		Boolean isProduct1Saved = productService.save(product1);

		if (isProduct1Saved) {
			log.info("Product [{}] saved successfully", product1.getName());
		} else {
			log.info("Product [{}] saving failed", product1.getName());
		}

		ProductDto product2 = new ProductDto();
		product2.setId(UUID.randomUUID().toString());
		product2.setName("Product 2");
		product2.setUnitPrice(200.00);

		Boolean isProduct2Saved = productService.save(product2);

		if (isProduct2Saved) {
			log.info("Product [{}] saved successfully", product2.getName());
		} else {
			log.info("Product [{}] saving failed", product2.getName());
		}

		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setId(UUID.randomUUID().toString());
		ordersDto.setNumber("ORD-001");
		ordersDto.setAmount(300.00);
		ordersDto.setCreatedTime(new Date());
		ordersDto.getProducts().add(product1);
		ordersDto.getProducts().add(product2);

		Boolean isOrderSaved = ordersService.save(ordersDto);

		if (isOrderSaved) {
			log.info("Order [{}] saved successfully", ordersDto.getNumber());
		} else {
			log.info("Order [{}] saving failed", ordersDto.getNumber());
		}

		log.info("[FIND_BY_ID] {}", ordersService.findById(ordersDto.getId()));

		log.info("[FIND_ALL] {}", ordersService.findAll());

		// Pagination example with page size 10
		log.info("[FIND_ALL_BY_PAGINATION] {}", ordersService.findAllByPage(PageRequest.of(0,10)));

		// Sort by order number in ascending order
		log.info("[FIND_ALL_BY_SORT] {}", ordersService.findAllBySort(Sort.by(Sort.Direction.fromString("ASC"), "number")));

		// Sort by order number in descending order and pagination with page size 10
		log.info("[FIND_ALL_BY_SORT_AND_PAGINATION] {}", ordersService.findAllBySortAndPage(PageRequest.of(0,10, Sort.by(Sort.Direction.fromString("DESC"), "number"))));

		log.info("[UPDATE]");
		ordersDto.setAmount(200.00);
		ordersDto.getProducts().remove(product1);
		Boolean isOrderUpdated = ordersService.update(ordersDto);

		if (isOrderUpdated) {
			log.info("Order [{}] updated successfully", ordersDto.getNumber());
		} else {
			log.info("Order [{}] updating failed", ordersDto.getNumber());
		}

		log.info("[FIND_BY_ID] {}", ordersService.findById(ordersDto.getId()));

		log.info("[DELETE]");
		ordersService.delete(ordersDto.getId());
		log.info("Order [{}] deleted successfully", ordersDto.getNumber());

		log.info("[FIND_ALL] {}", ordersService.findAll());
	}
}
