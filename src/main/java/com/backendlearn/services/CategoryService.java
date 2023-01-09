package com.backendlearn.services;

import com.backendlearn.dto.CategoryDto;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
	
	
	////create
	public CategoryDto insertCategory(CategoryDto categoryDto);
	////update
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	////delete
	public Integer deleteCategory(Integer id);
	///getall
	public List<CategoryDto> getCategories();
	///singledate
    public CategoryDto getCategoryById(Integer id);
}
