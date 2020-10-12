package com.example.Bookstore.domains;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;



public interface BookRepository extends CrudRepository<Book, Long>{
	
	Optional<Book> findById(Long bookId);
}
