package com.stratio.cockpit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stratio.cockpit.model.Cluster;


@Repository
public interface ClusterRepository extends JpaRepository<Cluster, Long> {

}
