package org.springframework.samples.petclinic.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Product;
import org.springframework.samples.petclinic.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional
	public Collection<Product> findAll() {
		return repository.findAll();
	}
	
	@Transactional
	public void save(Product product) {
		repository.save(product);
	}
	
	@Transactional
	public void delete(Product product) {
		repository.delete(product);
	}
	
	@Transactional
	public Product findById(int productId) {
		return repository.findById(productId);
	}
	
	@Transactional
	public Collection<Product> findProductByName(String name) {
		return repository.findByName(name);
	}

}