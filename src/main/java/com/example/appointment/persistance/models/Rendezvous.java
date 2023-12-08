package com.example.appointment.persistance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateRDV;
    private LocalDateTime heureRDV;

    @ManyToOne
    @JoinColumn(name = "fk_patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "fk_medecin_id")
    private Medecin medecin;

    //In this case he will create a new attribute for the foreign key : by default the name of the attribute is the other entity class name _ the name of the id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_consultation_id") //Use JoinColumn to rename the new attribute
    private Consultation consultation;
}
