package org.springframework.samples.petclinic.model;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "purchase")
public class Purchase extends BaseEntity{

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	private Double total;

	private Double vat;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "purchase")
	private Set<ProductPurchase> productPurchases;
	
	public int getProductsSize() {
		return productPurchases.size();
	}
}
