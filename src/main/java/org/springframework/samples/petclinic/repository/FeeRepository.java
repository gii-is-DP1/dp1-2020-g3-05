package org.springframework.samples.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Fee;

public interface FeeRepository extends CrudRepository<Fee, Integer>{

}
