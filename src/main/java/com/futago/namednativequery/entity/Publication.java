package com.futago.namednativequery.entity;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import lombok.Data;

@SqlResultSetMapping(
		  name="PublicationResult", 
		  classes={
			 @ConstructorResult(
				  targetClass = Publication.class,
				  columns={ 
				     @ColumnResult(name="title", type = String.class),
				     @ColumnResult(name="pages", type = String.class),
				     @ColumnResult(name="author", type = String.class),
				     @ColumnResult(name="authorAge", type = Integer.class),
				     @ColumnResult(name="authorGender", type = String.class)})})

@NamedNativeQuery(
		  name = "Publication.findByAge",
		  query = "SELECT b.title AS title, b.number_pages AS pages, a.name AS author, EXTRACT(YEAR FROM age(a.birthday)) AS authorAge, " + 
		  		"CASE " + 
		  		"	WHEN a.gender = 'M' THEN 'Male' " + 
		  		"	WHEN a.gender = 'F' THEN 'Female' " + 
		  		"END AS authorGender " + 
		  		"FROM author_book ab " + 
		  		"INNER JOIN book b ON b.id = ab.book_id " + 
		  		"INNER JOIN author a ON a.id = ab.author_id " + 
		  		"WHERE a.birthday IS NOT NULL",
		  resultSetMapping = "PublicationResult")

@Entity
@Data
public class Publication {

	@Id
	private Long id;
	private String title;
	private String pages;
	private String author;
	private Integer authorAge;
	private String authorGender;
	
	public Publication(String title, String pages, String author, Integer authorAge, String authorGender) {
		this.title = title;
		this.pages = pages;
		this.author = author;
		this.authorAge = authorAge;
		this.authorGender = authorGender;
	}
}