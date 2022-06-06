package com.spring.restapi.grocerystore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.restapi.grocerystore.dao.CategoryRepository;
import com.spring.restapi.grocerystore.model.Category;

@Service
@Transactional
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryrepository) {
		this.categoryRepository = categoryrepository;
	}

	public List<Category> listCategories() {
		return categoryRepository.findAll();
	}

	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	public Category readCategory(String categoryName) {
		return categoryRepository.findByCategoryName(categoryName);
	}

	public Optional<Category> readCategory(Integer categoryId) {
		return categoryRepository.findById(categoryId);
	}

	public void updateCategory(Integer categoryID, Category newCategory) {
		Category category = categoryRepository.findById(categoryID).get();
		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());
		category.setBrand(newCategory.getBrand());
		category.setProducts(newCategory.getProducts());
		category.setImageURL(newCategory.getImageURL());

		categoryRepository.save(category);
	}
}
