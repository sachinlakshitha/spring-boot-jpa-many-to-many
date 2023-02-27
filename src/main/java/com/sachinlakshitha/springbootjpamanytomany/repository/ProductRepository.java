package com.sachinlakshitha.springbootjpamanytomany.repository;

import com.sachinlakshitha.springbootjpamanytomany.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
