package com.example.Bookstore.domains;
import java.util.List;


import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category>findByName(String name);
	
	
}
