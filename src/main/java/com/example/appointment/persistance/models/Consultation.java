package com.example.appointment.persistance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCons;
    private String recapCons;

    //If we want the relationship to be bidirectional (can access to consultation from rendervous and you can access to rendervou from consultation) add this lines
    //If you want it to be unidirectional just remove these lines
    @OneToOne(mappedBy = "consultation") // mapped by (use the name you set in the other table)
    private Rendezvous Rendezvous;

}
