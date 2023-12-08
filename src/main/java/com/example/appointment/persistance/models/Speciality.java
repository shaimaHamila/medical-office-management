package com.example.appointment.persistance.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Speciality{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String specialityName;

	//In case of unidirectional relationship you can choose where to put the relationship in this class or the other class, It depends on your needs
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "fk_speciality_id") // this will add an attribute in medecin table called fk_speciality_id
//	private List<Medecin> medecins;

	//In case of bidirectional relationship
	/*
	* In a bidirectional relationship, where both entities are aware of the relationship,
	* you typically use the @JoinColumn annotation,
	* but it's applied on one side of the relationship.
	*/
//	@OneToMany(mappedBy = "speciality" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonIgnore
//	private List<Medecin> medecins;
}
