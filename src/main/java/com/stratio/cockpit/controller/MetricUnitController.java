package com.stratio.cockpit.controller;

import com.stratio.cockpit.exception.ResourceNotFoundException;
import com.stratio.cockpit.model.MetricUnit;
import com.stratio.cockpit.repository.MetricUnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/metricUnits")
public class MetricUnitController {

    @Autowired
    MetricUnitRepository metricRepository;

    @GetMapping
    public List<MetricUnit> getAllMetricUnits() {
        return metricRepository.findAll();
    } 

    @PostMapping
    public MetricUnit createMetricUnit(@Valid @RequestBody MetricUnit metricUnit) {
        return metricRepository.save(metricUnit);
    }

    @GetMapping("/{id}")
    public MetricUnit getMetricUnitById(@PathVariable(value = "id") Long metricUnitId) {
        return metricRepository.findById(metricUnitId)
                .orElseThrow(() -> new ResourceNotFoundException("MetricUnit", "id", metricUnitId));
    }

    @PutMapping("/{id}")
    public MetricUnit updateMetricUnit(@PathVariable(value = "id") Long metricUnitId,
                                           @Valid @RequestBody MetricUnit metricUnitDetails) {

        MetricUnit metricUnit = metricRepository.findById(metricUnitId)
                .orElseThrow(() -> new ResourceNotFoundException("MetricUnit", "id", metricUnitId));

        metricUnit.setName(metricUnitDetails.getName());

        MetricUnit updatedMetricUnit = metricRepository.save(metricUnit);
        return updatedMetricUnit;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMetricUnit(@PathVariable(value = "id") Long metricUnitId) {
        MetricUnit metricUnit = metricRepository.findById(metricUnitId)
                .orElseThrow(() -> new ResourceNotFoundException("MetricUnit", "id", metricUnitId));

        metricRepository.delete(metricUnit);

        return ResponseEntity.ok().build();
    }
}
