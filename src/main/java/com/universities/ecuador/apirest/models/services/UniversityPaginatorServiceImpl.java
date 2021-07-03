package com.universities.ecuador.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.universities.ecuador.apirest.models.daos.IUniversityPaginatorDao;
import com.universities.ecuador.apirest.models.entities.University;

@Service("paginator")
public class UniversityPaginatorServiceImpl implements IUniversityService {

	@Autowired
	private IUniversityPaginatorDao univsService;
	
	@Override
	public List<University> findAll() {
	
		return (List<University>) univsService.findAll(sortByIdAsc());
	}
	
	private Sort sortByIdAsc() {
		return Sort.by("name").ascending();
	}

	@Override
	public University findById(String id) {
		
		return univsService.findById(id).orElse(null);
	}

	@Override
	public University save(University university) {
		return this.univsService.save(university);
	}

	@Override
	public void delete(String id) {
		this.univsService.deleteById(id);
		
	}

	@Override
	public Page<University> findAll(Pageable pageable) {
		return this.univsService.findAll(pageable);
	}

	
}
