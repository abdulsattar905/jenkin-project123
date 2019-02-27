package com.neosoft.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neosoft.Repository.BookRepository;
import com.neosoft.entity.Author;
import com.neosoft.entity.Book;

@Controller
public class BookController {

	@Autowired
	BookRepository bookRepo;

	@RequestMapping(value = "addBook"/* , method=RequestMethod.POST */)
	public String saveOrUpdate(Book book, Map<String, Object> model) {
		System.out.println("public String saveOrUpdate(Book book,");
		bookRepo.save(book);
		List<Book> bookList = (List) bookRepo.findAll();
		model.put("bookList", bookList);
		return "bookList";
	}

	@PostMapping("/updateBook/{id}")
	public String Update(@PathVariable("id") int id, @Valid Book book, BindingResult result,
			Map<String, Object> model) {
		if (result.hasErrors()) {
			book.setId(id);
			return "Edit";
		}

		bookRepo.save(book);
		List<Author> authorList = (List) bookRepo.findAll();
		model.put("bookList", authorList);
		return "bookList";
	}

	@GetMapping("/editBook/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Book book = bookRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

		model.addAttribute("book", book);
		return "bookEdit";
	}
	
	@RequestMapping(value = "/deleteBook/{id}")
	public String delete( @PathVariable("id")  Integer id, Map<String, Object> model) {
		System.out.println("hi");
		bookRepo.deleteById(id);
		
		 List<Book> bookList = (List) bookRepo.findAll();
		    model.put("bookList", bookList);
			return "bookList";
	}
	

}
