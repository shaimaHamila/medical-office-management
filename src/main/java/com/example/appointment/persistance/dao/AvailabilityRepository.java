package com.example.appointment.persistance.dao;

import com.example.appointment.persistance.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

}
