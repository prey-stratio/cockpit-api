package com.stratio.cockpit.controller;

import com.stratio.cockpit.exception.ResourceNotFoundException;
import com.stratio.cockpit.model.Pharmacy;
import com.stratio.cockpit.repository.PharmacyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/pharmacy")
public class PharmacyController {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @GetMapping
    public List<Pharmacy> getAllPharmacys() {
        return pharmacyRepository.findAll();
    } 

    @PostMapping
    public Pharmacy createPharmacy(@Valid @RequestBody Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @GetMapping("/{id}")
    public Pharmacy getPharmacyById(@PathVariable(value = "id") Long pharmacyId) {
        return pharmacyRepository.findById(pharmacyId)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy", "id", pharmacyId));
    }

    @PutMapping("/{id}")
    public Pharmacy updatePharmacy(@PathVariable(value = "id") Long pharmacyId,
                                           @Valid @RequestBody Pharmacy pharmacyDetails) {

        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy", "id", pharmacyId));

        pharmacy.setName(pharmacyDetails.getName());
        pharmacy.setCity(pharmacyDetails.getCity());

        Pharmacy updatedPharmacy = pharmacyRepository.save(pharmacy);
        return updatedPharmacy;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePharmacy(@PathVariable(value = "id") Long pharmacyId) {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
                .orElseThrow(() -> new ResourceNotFoundException("Pharmacy", "id", pharmacyId));

        pharmacyRepository.delete(pharmacy);

        return ResponseEntity.ok().build();
    }
}
