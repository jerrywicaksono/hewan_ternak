package com.cattle.livestocks.repository.entities;

import java.util.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "core_animal")
@Where(clause = " status <> 'HIST' OR  status is null ")
@SQLDelete(sql = "update core_animal set status='HIST' where id=?")
public class CoreAnimal extends BaseModel {
	private static final long serialVersionUID = 9084799606509585365L;

	@Id
	@SequenceGenerator(name = "core_animal_seq", sequenceName = "core_animal_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "core_animal_seq")
	private Long id;
	private String animalCode;
	private String animalType;
	private String animalName;
	private float animalBuyPrice;
	private float animalSellPrice;
	private Date dateOfEntry;
	private Date dateOfBirth;
	private String animalInitialWeight;
	private String animalAge;
	private String animalInitialCondition;
	private String animalCompleteness;
}