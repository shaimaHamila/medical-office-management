package com.example.appointment.persistance.dao;

import com.example.appointment.persistance.models.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
}
