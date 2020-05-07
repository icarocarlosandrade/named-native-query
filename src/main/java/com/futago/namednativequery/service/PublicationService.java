package com.futago.namednativequery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futago.namednativequery.entity.Publication;
import com.futago.namednativequery.repository.PublicationRepository;

@Service
public class PublicationService {

	private PublicationRepository repository;
	
	@Autowired
	public PublicationService(PublicationRepository publicationRepository) {
		repository = publicationRepository;
	}
	
	public List<Publication> findAll() {
		return repository.findByAge();
	}
}