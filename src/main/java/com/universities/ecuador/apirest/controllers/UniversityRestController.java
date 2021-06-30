package com.universities.ecuador.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.universities.ecuador.apirest.models.entities.University;
import com.universities.ecuador.apirest.models.services.IUniversityService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class UniversityRestController {

	@Autowired
	private IUniversityService univsService;

	@GetMapping("/universities")
	@ResponseStatus(HttpStatus.OK)
	public List<University> getAll() {
		return this.univsService.findAll();
	}

	@GetMapping("/universities/{id}")
	public ResponseEntity<?> getById(@PathVariable String id) {
		Map<String, Object> response = new HashMap<>();
		University university = null;
		try {
			university = univsService.findById(id);
		} catch (DataAccessException e) {
			response.put("message", "Database error");
			response.put("errors", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (university == null) {
			response.put("message", "Data not found");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<University>(university, HttpStatus.OK);
	}

	@PostMapping("/universities")
	public University save(@RequestBody University university) {
		return this.univsService.save(university);
	}

	@PutMapping("/universities/{id}")
	public ResponseEntity<?> update(@RequestBody University university, @PathVariable String id) {
		Map<String, Object> response = new HashMap<>();
		University unvFound, unvUpdated = null;
		try {
			unvFound = univsService.findById(id);
		} catch (DataAccessException e) {
			response.put("message", "Database error find");
			response.put("errors", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (unvFound == null) {
			response.put("message", "Data not found");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			unvFound.setAcronym(university.getAcronym());
			unvFound.setAddress(university.getAddress());
			unvFound.setCategory(university.getCategory());
			unvFound.setCity(university.getCity());
			unvFound.setEmail(university.getEmail());
			unvFound.setFinancing(university.getFinancing());
			unvFound.setImageUrl(university.getImageUrl());
			unvFound.setName(university.getName());
			unvFound.setProvince(university.getProvince());
			unvFound.setRector(university.getRector());
			unvFound.setSite(university.getSite());
			unvFound.setStudents(university.getStudents());
			unvUpdated = this.univsService.save(unvFound);
		} catch (Exception e) {
			response.put("message", "Database error update");
			response.put("errors", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (unvUpdated == null) {
			response.put("message", "Data not found");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<University>(unvUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/universities/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		Map<String, Object> response = new HashMap<>();
		University unvFound = null;
		try {
			unvFound = univsService.findById(id);
		} catch (DataAccessException e) {
			response.put("message", "Database error find");
			response.put("errors", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (unvFound == null) {
			response.put("message", "Data not found");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		
		try {
			this.univsService.delete(id);
		} catch (Exception e) {
			response.put("message", "Something goes wrong");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
		}
		response.put("message", "Data deleted successfully");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
