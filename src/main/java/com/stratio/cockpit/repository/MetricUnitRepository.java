package com.stratio.cockpit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stratio.cockpit.model.MetricUnit;


@Repository
public interface MetricUnitRepository extends JpaRepository<MetricUnit, Long> {

}
