/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Exercise;
import org.springframework.samples.petclinic.model.ExerciseType;
import org.springframework.samples.petclinic.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class WorkoutService {

	private ExerciseRepository exerciseRepository;
	
	// private VisitRepository visitRepository;
	
 
	@Autowired
	public WorkoutService(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}

	@Transactional(readOnly = true)
	public Collection<ExerciseType> findExerciseTypes() throws DataAccessException {
		return exerciseRepository.findExerciseTypes();
	}
	
	@Transactional
	public void saveExercise(Exercise exercise) throws DataAccessException {
		exerciseRepository.save(exercise);
	}
	
	@Transactional
	public void deleteExercise(Exercise exercise) throws DataAccessException {
		exerciseRepository.delete(exercise);
	}

	@Transactional(readOnly = true)
	public Exercise findExerciseById(int id) throws DataAccessException {
		return exerciseRepository.findById(id);
	}

	/* @Transactional()
	public void savePet(Pet pet) throws DataAccessException, DuplicatedPetNameException {
			Pet otherPet=pet.getOwner().getPetwithIdDifferent(pet.getName(), pet.getId());
            if (StringUtils.hasLength(pet.getName()) &&  (otherPet!= null && otherPet.getId()!=pet.getId())) {            	
            	throw new DuplicatedPetNameException();
            }else
                petRepository.save(pet);                
	} */


	public Collection<Exercise> findExercises() {
		return exerciseRepository.findAll();
	}

}
