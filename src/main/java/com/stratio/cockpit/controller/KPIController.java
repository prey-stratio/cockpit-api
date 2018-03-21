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
import com.stratio.cockpit.model.Kpi;
import com.stratio.cockpit.repository.KpiRepository;


@RestController
@RequestMapping("/api/kpi")
public class KPIController {

    @Autowired
    KpiRepository kpiRepository;

    @GetMapping
    public List<Kpi> getAllKpis() {
        return kpiRepository.findAll();
    } 

    @PostMapping
    public Kpi createKpi(@Valid @RequestBody Kpi kpi) {
        return kpiRepository.save(kpi);
    }

    @GetMapping("/{id}")
    public Kpi getKpiById(@PathVariable(value = "id") Long kpiId) {
        return kpiRepository.findById(kpiId)
                .orElseThrow(() -> new ResourceNotFoundException("Kpi", "id", kpiId));
    }

    @PutMapping("/{id}")
    public Kpi updateKpi(@PathVariable(value = "id") Long kpiId,
                                           @Valid @RequestBody Kpi kpiDetails) {

        Kpi kpi = kpiRepository.findById(kpiId)
                .orElseThrow(() -> new ResourceNotFoundException("Kpi", "id", kpiId));

        kpi.setNos(kpiDetails.getNos());
        kpi.setUnitNOS(kpiDetails.getUnitNOS());
        kpi.setPowerSegments(kpiDetails.getPowerSegments());
        kpi.setPowerSKU(kpiDetails.getPowerSKU());
        kpi.setTotalShareAllBrands(kpiDetails.getTotalShareAllBrands());
        kpi.setVisibilityObjectives(kpiDetails.getVisibilityObjectives());
        kpi.setMixIT(kpiDetails.getMixIT());
        kpi.setCustomerRightFrequency(kpiDetails.getCustomerRightFrequency());

        
        Kpi updatedKpi = kpiRepository.save(kpi);
        return updatedKpi;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKpi(@PathVariable(value = "id") Long kpiId) {
        Kpi kpi = kpiRepository.findById(kpiId)
                .orElseThrow(() -> new ResourceNotFoundException("Kpi", "id", kpiId));

        kpiRepository.delete(kpi);

        return ResponseEntity.ok().build();
    }
}
