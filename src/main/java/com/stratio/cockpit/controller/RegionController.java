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
import com.stratio.cockpit.model.Region;
import com.stratio.cockpit.repository.RegionRepository;


@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    } 

    @PostMapping
    public Region createRegion(@Valid @RequestBody Region region) {
        return regionRepository.save(region);
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable(value = "id") Long regionId) {
        return regionRepository.findById(regionId)
                .orElseThrow(() -> new ResourceNotFoundException("Region", "id", regionId));
    }

    @PutMapping("/{id}")
    public Region updateRegion(@PathVariable(value = "id") Long regionId,
                                           @Valid @RequestBody Region regionDetails) {

        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new ResourceNotFoundException("Region", "id", regionId));

        region.setName(regionDetails.getName());

        Region updatedRegion = regionRepository.save(region);
        return updatedRegion;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable(value = "id") Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new ResourceNotFoundException("Region", "id", regionId));

        regionRepository.delete(region);

        return ResponseEntity.ok().build();
    }
}
