package org.springframework.samples.petclinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Data;

@Audited
@Data
@Entity
@Table(name = "workout_training")
public class WorkoutTraining extends AuditableEntity {
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "workout_id")
	Workout workout;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "training_id")
	Training training;
	
	@Column(name = "week_day")
	Integer weekDay;
	
}
