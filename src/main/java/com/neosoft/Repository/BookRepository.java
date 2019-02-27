package com.neosoft.Repository;

import org.springframework.data.repository.CrudRepository;

import com.neosoft.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
