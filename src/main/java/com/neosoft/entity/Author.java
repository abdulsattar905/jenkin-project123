package com.neosoft.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {
	
	@Id
	private int id;
	private String name;
	
	@ManyToMany/*(targetEntity =Book.class ,cascade=CascadeType.ALL)
    @JoinTable(
        name = "Author_Book", 
        joinColumns = { @JoinColumn(name = "author_id",referencedColumnName="id") }, 
        inverseJoinColumns = { @JoinColumn(name = "book_id",referencedColumnName="id") }
    )*/
	private Set<Book> books;

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
	public Set<Book> getBook() {
		return books;
	}
	public void setBook(Set<Book> books) {
		books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
}
