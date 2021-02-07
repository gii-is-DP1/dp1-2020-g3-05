package org.springframework.samples.petclinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Audited
@Getter
@Setter
@Entity
@Table(name = "sale")
public class Sale extends AuditableEntity {

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	private Double total;

	private Double vat;
	
	@NotAudited
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "sale")
	private Set<ProductSale> productSales;
	
	public int getProductsSize() {
		return productSales.size();
	}
}
