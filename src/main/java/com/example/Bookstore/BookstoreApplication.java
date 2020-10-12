package com.example.Bookstore;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domains.Book;
import com.example.Bookstore.domains.BookRepository;
import com.example.Bookstore.domains.Category;
import com.example.Bookstore.domains.CategoryRepository;




@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger Log= LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner addBooks(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			Log.info("save a couple of books");
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Culture"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Bio"));
			
			LocalDate pvm = LocalDate.parse("2020-04-20");
			java.util.Date date = java.sql.Date.valueOf(pvm);
		
			brepository.save(new Book("Muumi", "Tove Jansen", 1994, "12341245", 9.99, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("Harry Potter", "J.K. Rowling", 2002, "439853785", 7.99, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("The Capital", "Marx", 1890, "123-234", 99.90, crepository.findByName("Bio").get(0)));
			brepository.save(new Book("Nykypaivien Saksa", "Sven", 1935, "123-2346", 189.90, crepository.findByName("Horror").get(0)));
			Log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				Log.info(book.toString());
			}
			
		};
}
}
