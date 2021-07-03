package com.universities.ecuador.apirest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.universities.ecuador.apirest.models.entities.University;
import com.universities.ecuador.apirest.models.services.IUniversityService;
import com.universities.ecuador.apirest.util.PageRender;

@Controller
@RequestMapping("/view")
public class UniversityViewController {

	@Autowired
	@Qualifier("paginator")
	private IUniversityService univsService;

	@GetMapping(value = "/universities")
	public String index(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 5, Sort.by("name").ascending());
		Page<University> unvs = univsService.findAll(pageRequest);
		PageRender<University> pageRender = new PageRender<University>("/view/universities", unvs, 7);
		model.addAttribute("unvs", unvs.toList());
		model.addAttribute("page", pageRender);
		return "index";
	}

}
