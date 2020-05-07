package com.futago.namednativequery.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futago.namednativequery.entity.Publication;
import com.futago.namednativequery.service.PublicationService;

@RestController
@RequestMapping("/publications")
public class PublicationRestController {

	private PublicationService service;

	@Autowired
	public PublicationRestController(PublicationService publicationService) {
		service = publicationService;
	}

	@GetMapping
	public List<Publication> findAll() {
		return service.findAll();
	}
}
