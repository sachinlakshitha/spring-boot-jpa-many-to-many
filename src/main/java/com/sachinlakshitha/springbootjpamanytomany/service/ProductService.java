package com.sachinlakshitha.springbootjpamanytomany.service;

import com.sachinlakshitha.springbootjpamanytomany.dto.ProductDto;

public interface ProductService {
    Boolean save(ProductDto productDto);
}
