package com.stratio.cockpit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stratio.cockpit.exception.ResourceNotFoundException;
import com.stratio.cockpit.model.Cluster;
import com.stratio.cockpit.repository.ClusterRepository;


@RestController
@RequestMapping("/api/clusters")
public class ClusterController {

    @Autowired
    ClusterRepository clusterRepository;

    @GetMapping
    public List<Cluster> getAllClusters() {
        return clusterRepository.findAll();
    } 

    @PostMapping
    public Cluster createCluster(@Valid @RequestBody Cluster cluster) {
        return clusterRepository.save(cluster);
    }

    @GetMapping("/{id}")
    public Cluster getClusterById(@PathVariable(value = "id") Long clusterId) {
        return clusterRepository.findById(clusterId)
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "id", clusterId));
    }

    @PutMapping("/{id}")
    public Cluster updateCluster(@PathVariable(value = "id") Long clusterId,
                                           @Valid @RequestBody Cluster clusterDetails) {

        Cluster cluster = clusterRepository.findById(clusterId)
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "id", clusterId));

        cluster.setName(clusterDetails.getName());

        Cluster updatedCluster = clusterRepository.save(cluster);
        return updatedCluster;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCluster(@PathVariable(value = "id") Long clusterId) {
        Cluster cluster = clusterRepository.findById(clusterId)
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "id", clusterId));

        clusterRepository.delete(cluster);

        return ResponseEntity.ok().build();
    }
}
