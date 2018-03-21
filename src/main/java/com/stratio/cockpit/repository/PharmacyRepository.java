package com.stratio.cockpit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stratio.cockpit.model.Pharmacy;


@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
