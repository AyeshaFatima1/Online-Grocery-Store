package com.spring.restapi.grocerystore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.restapi.grocerystore.dto.ProductDto;
import com.spring.restapi.grocerystore.model.Category;
import com.spring.restapi.grocerystore.model.Product;
import com.spring.restapi.grocerystore.response.ApiResponse;
import com.spring.restapi.grocerystore.service.CategoryService;
import com.spring.restapi.grocerystore.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
	
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    @PostMapping("/update/{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Integer productID, @RequestBody @Valid ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id){
    	Product product=productService.getProductById(id);
    	return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id) {
    	productService.deleteProduct(id);
    	return "Product deleted successfully";
    }
  
     @GetMapping("/search")
     public ResponseEntity<List<Product>> viewHomePage(@Param("keyword") String keyword){
     	List<Product> body=productService.listAll(keyword);
     	return new ResponseEntity<List<Product>>(body,HttpStatus.OK);
     }
}
