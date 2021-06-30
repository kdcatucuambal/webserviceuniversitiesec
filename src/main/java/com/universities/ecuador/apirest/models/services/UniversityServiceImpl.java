package com.universities.ecuador.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universities.ecuador.apirest.models.daos.IUniversityDao;
import com.universities.ecuador.apirest.models.entities.University;

@Service
public class UniversityServiceImpl implements IUniversityService {

	@Autowired
	private IUniversityDao univsDao;

	@Override
	public List<University> findAll() {
		return (List<University>) univsDao.findAll();
	}

	@Override
	public University findById(String id) {
		return univsDao.findById(id).orElse(null);
	}

	@Override
	public University save(University university) {
		return univsDao.save(university);
	}

	@Override
	public void delete(String id) {
		univsDao.deleteById(id);
	}

}
