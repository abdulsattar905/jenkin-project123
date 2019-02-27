package com.neosoft.Repository;

import org.springframework.data.repository.CrudRepository;

import com.neosoft.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
