package com.org.xochitl.demo.repository;

import com.org.xochitl.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
