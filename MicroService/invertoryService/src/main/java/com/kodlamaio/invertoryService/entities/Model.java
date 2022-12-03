package com.kodlamaio.invertoryService.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="models")
public class Model {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@OneToMany(mappedBy = "model")
	List<Car> cars;
}
