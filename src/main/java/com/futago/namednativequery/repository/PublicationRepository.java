package com.futago.namednativequery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futago.namednativequery.entity.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

	List<Publication> findByAge();
}
