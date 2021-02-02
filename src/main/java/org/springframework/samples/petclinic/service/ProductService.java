package org.springframework.samples.petclinic.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Product;
import org.springframework.samples.petclinic.model.Purchase;
import org.springframework.samples.petclinic.model.Sale;
import org.springframework.samples.petclinic.repository.ProductPurchaseRepository;
import org.springframework.samples.petclinic.repository.ProductRepository;
import org.springframework.samples.petclinic.repository.PurchaseRepository;
import org.springframework.samples.petclinic.repository.SaleRepository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ProductPurchaseRepository productPurchaseRepository;
	
	
	@Transactional
	public Collection<Product> findAllProducts() {
		return productRepository.findAll();
	}
	
	@Transactional
	public void saveProduct(Product product) {
		productRepository.save(product);
		log.info("saved product with ID = " + product.getId()); 
	}
	
	@Transactional
	public void deleteProduct(Product product) {
		
		// TODO si falla el borrado revisar que hacer con product purchase
		
		productRepository.delete(product);
		log.info("deleted product with ID = " + product.getId()); 
	}
	
	@Transactional
	public Product findProductById(int productId) {
		return productRepository.findById(productId);
	}
	
	@Transactional
	public Collection<Product> findProductByName(String name) {
		if (name == null) {
			return productRepository.findAll();
		}
		return productRepository.findByName(name);
	}
	
	@Transactional
	public Collection<Purchase> findAllPurchases() {
		return purchaseRepository.findAll();
	}
	
	@Transactional
	public void savePurchase(Purchase purchase) {
		purchaseRepository.save(purchase);
		log.info("saved purchase with ID = " + purchase.getId()); 
	}
	
	@Transactional
	public void deletePurchase(Purchase purchase) {
		purchaseRepository.delete(purchase);
		log.info("deleted purchase with ID = " + purchase.getId()); 
	}
	
	@Transactional
	public Sale findSaleById(int saleId) {
		return saleRepository.findById(saleId);
	}
	
	@Transactional
	public Collection<Sale> findAllSales() {
		return saleRepository.findAll();
	}
	
	@Transactional
	public void savePurchase(Sale sale) {
		saleRepository.save(sale);
		log.info("saved sale with ID = " + sale.getId()); 
	}
	
	@Transactional
	public void deletePurchase(Sale sale) {
		saleRepository.delete(sale);
		log.info("deleted sale with ID = " + sale.getId()); 
	}
	
	@Transactional
	public Purchase findPurchaseById(int purchaseId) {
		return purchaseRepository.findById(purchaseId);
	}
	
	/* @Transactional
	public void saveProductPurchase(Purchase purchase) {
		purchaseRepository.save(purchase);
	}
	
	@Transactional
	public void deleteProductPurchase(Purchase purchase) {
		purchaseRepository.delete(purchase);
	} */
	
}
