package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Fee extends BaseEntity{

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	LocalDate start_date;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	LocalDate end_date;
	
	Double amount;
	
	@Enumerated(EnumType.STRING)
	Rate rate;
	
	@OneToOne(mappedBy = "fee")
	private Usuario usuario;
}
