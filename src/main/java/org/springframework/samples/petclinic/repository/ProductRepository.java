package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Product;

public interface ProductRepository extends Repository<Product, Integer> {
	
	public Product findById(int id);
	
	public Collection<Product> findAllByInactiveFalse() throws DataAccessException;

	public Collection<Product> findByNameContainingAndInactiveFalse(String name);

	void save(Product product) throws DataAccessException;
}
