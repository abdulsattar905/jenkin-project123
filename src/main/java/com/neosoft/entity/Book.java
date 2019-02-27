package com.neosoft.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	private int id;
	private String name;
	private String isbn;
	
	@ManyToMany/*(targetEntity =Author.class ,mappedBy = "Book")*/
	private Set<Author> authors;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Set<Author> getAuthor() {
		return authors;
	}
	public void setAuthor(Set<Author> authors) {
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + ", author=" + authors + "]";
	}
	
	
	

}
