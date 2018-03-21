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
import com.stratio.cockpit.model.City;
import com.stratio.cockpit.repository.CityRepository;


@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping
    public List<City> getAllCitys() {
        return cityRepository.findAll();
    } 

    @PostMapping
    public City createCity(@Valid @RequestBody City customer) {
        return cityRepository.save(customer);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable(value = "id") Long customerId) {
        return cityRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", customerId));
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable(value = "id") Long customerId,
                                           @Valid @RequestBody City customerDetails) {

        City customer = cityRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", customerId));

        customer.setName(customerDetails.getName());

        City updatedCity = cityRepository.save(customer);
        return updatedCity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable(value = "id") Long customerId) {
        City customer = cityRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("City", "id", customerId));

        cityRepository.delete(customer);

        return ResponseEntity.ok().build();
    }
}
