package com.universities.ecuador.apirest.models.services;

import java.util.List;

import com.universities.ecuador.apirest.models.entities.University;

public interface IUniversityService {

	public List<University> findAll();

	public University findById(String id);

	public University save(University university);

	public void delete(String id);

}
