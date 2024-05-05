package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable String id) {
		return repository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public Product update(@PathVariable String id, @RequestBody Product product) {
		var p = repository.findById(id).orElse(null);
		if(p != null) {
			p.setName(product.getName());
			return repository.save(p);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
}
