package com.universities.ecuador.apirest.models.daos;

import org.springframework.data.repository.CrudRepository;

import com.universities.ecuador.apirest.models.entities.University;

public interface IUniversityDao extends CrudRepository<University, String> {

}
