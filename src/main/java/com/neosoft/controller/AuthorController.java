package com.neosoft.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neosoft.Repository.AuthorRepository;
import com.neosoft.entity.Author;

@Controller
public class AuthorController {

	@Autowired
	AuthorRepository authorRepo;

	@RequestMapping("home")
	public String home() {
		System.out.println("hello home");
		return "home.html";
	}

	@RequestMapping(value="add")
	public String saveOrUpdate(Author author, Map<String, Object> model) {

		authorRepo.save(author);
		List<Author> authorList = (List) authorRepo.findAll();
		model.put("authorlist", authorList);
		return "authorList";
	}
	
	
	@PostMapping("/update/{id}")
	public String Update(@PathVariable("id") int id, @Valid Author author, 
	  BindingResult result, Map<String, Object> model) {
	    if (result.hasErrors()) {
	    	author.setId(id);
	        return "Edit";
	    }
	         
	    authorRepo.save(author);
	    List<Author> authorList = (List) authorRepo.findAll();
	    model.put("authorlist", authorList);
		return "authorList";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Author author = authorRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	    model.addAttribute("author", author);
	    return "authorEdit";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete( @PathVariable("id")  Integer id, Map<String, Object> model) {
		System.out.println("hi");
		authorRepo.deleteById(id);
		
		 List<Author> authorList = (List) authorRepo.findAll();
		    model.put("authorlist", authorList);
			return "authorList";
	}

	/*@DeleteMapping("deleteAll")
	public String deleteAll() {
		authorRepo.deleteAll();
		return "redirect:/authorList";
	}*/

	@GetMapping(value = "/authorList", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllAuthor(Map<String, Object> model) {

		List<Author> authorList = (List) authorRepo.findAll();
		model.put("authorlist", authorList);
		return "authorList";
	}
}
