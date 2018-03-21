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
import com.stratio.cockpit.model.Brand;
import com.stratio.cockpit.repository.BrandRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/brands")
@Api(value = "brands", produces = "application/json")
public class BrandController {

	@Autowired
	BrandRepository brandRepository;

	@GetMapping
	@ApiOperation(value = "Get All Brands", notes = "Returns all brands")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exits one info at least") })
	public List<Brand> getAllBrands() {
		return brandRepository.findAll();
	}

	@PostMapping
	public Brand createBrand(@Valid @RequestBody Brand brand) {
		return brandRepository.save(brand);
	}

	@GetMapping("/{id}")
	public Brand getBrandById(@PathVariable(value = "id") Long brandId) {
		return brandRepository.findById(brandId)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", "id", brandId));
	}

	@PutMapping("/{id}")
	public Brand updateBrand(@PathVariable(value = "id") Long brandId, @Valid @RequestBody Brand brandDetails) {

		Brand brand = brandRepository.findById(brandId)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", "id", brandId));

		brand.setName(brandDetails.getName());

		Brand updatedBrand = brandRepository.save(brand);
		return updatedBrand;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable(value = "id") Long brandId) {
		Brand brand = brandRepository.findById(brandId)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", "id", brandId));

		brandRepository.delete(brand);

		return ResponseEntity.ok().build();
	}
}
