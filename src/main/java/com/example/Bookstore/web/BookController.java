package com.example.Bookstore.web;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domains.BookRepository;
import com.example.Bookstore.domains.CategoryRepository;
import com.example.Bookstore.domains.Book;

@Controller
public class BookController {
		@Autowired
		private BookRepository repository;
		
		@Autowired
		private CategoryRepository crepository;
		
		@RequestMapping(value= {"/bookList", "/" }, method=RequestMethod.GET)
	    public String bookList(Model model) {	
			model.addAttribute("books", repository.findAll());
	        return "bookList";
	    }
	 
	 	@RequestMapping(value = "/addbook")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("category", crepository.findAll());
	        return "addbook";
	    }  
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:bookList";
	    }  
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../bookList";
	    }    
	    @RequestMapping(value = "/modifybook/{id}", method = RequestMethod.GET)
	    public String modifyBook(@PathVariable("id") Long bookId, Model model) {
	    	
	    	Optional<Book> book = repository.findById(bookId);
	    	model.addAttribute("book",  repository.findById(bookId));
	    	model.addAttribute("category", crepository.findAll());
	    	
	    	
	        return "modifybook";
	    }   
}
