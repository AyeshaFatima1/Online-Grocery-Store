package com.spring.restapi.grocerystore.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.restapi.grocerystore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
   @Query("select p from Product p where concat(p.name,p.description) like %?3%")

	List<Product> search(String keyword);
	
	//Product findByProductName(String name);


}
