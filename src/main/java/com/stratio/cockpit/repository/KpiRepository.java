package com.stratio.cockpit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stratio.cockpit.model.Kpi;


@Repository
public interface KpiRepository extends JpaRepository<Kpi, Long> {

}
