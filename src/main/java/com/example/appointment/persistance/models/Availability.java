package com.example.appointment.persistance.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime StartTime;
    private LocalDateTime EndTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "medecin_availability",
            joinColumns = @JoinColumn(name = "med_id"),
            inverseJoinColumns = @JoinColumn(name = "av_id")
    )
    private List<Medecin> medecins;


}
