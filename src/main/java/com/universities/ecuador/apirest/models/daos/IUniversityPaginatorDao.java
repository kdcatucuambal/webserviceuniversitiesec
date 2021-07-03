package com.universities.ecuador.apirest.models.daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.universities.ecuador.apirest.models.entities.University;

public interface IUniversityPaginatorDao extends PagingAndSortingRepository<University, String> {

}
