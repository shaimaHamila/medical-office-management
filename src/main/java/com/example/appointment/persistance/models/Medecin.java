package com.example.appointment.persistance.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;

    @ManyToOne()
    @JoinColumn(name = "fk_speciality_id", nullable = false)
    private Speciality speciality;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.REMOVE)
    private List<Rendezvous> listrdv;

    @ManyToMany(mappedBy = "medecins")
    private List<Availability> availabilities;

}