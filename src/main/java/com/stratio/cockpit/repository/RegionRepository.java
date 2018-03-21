package com.stratio.cockpit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stratio.cockpit.model.Region;


@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
