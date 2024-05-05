package com.example.demo.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Product;

@EnableScan
public interface ProductRepository extends CrudRepository<Product, String> {

}
