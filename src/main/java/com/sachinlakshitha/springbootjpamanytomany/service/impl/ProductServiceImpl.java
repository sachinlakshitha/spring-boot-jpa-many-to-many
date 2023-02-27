package com.sachinlakshitha.springbootjpamanytomany.service.impl;

import com.sachinlakshitha.springbootjpamanytomany.dto.ProductDto;
import com.sachinlakshitha.springbootjpamanytomany.entity.Product;
import com.sachinlakshitha.springbootjpamanytomany.repository.ProductRepository;
import com.sachinlakshitha.springbootjpamanytomany.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Override
    public Boolean save(ProductDto productDto) {
        return productRepository.save(convertToEntity(productDto)) != null;
    }

    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public Product convertToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
