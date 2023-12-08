package com.example.appointment.persistance.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String email;

	@OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Rendezvous>rendezvousList;

}
