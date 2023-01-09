package com.backendlearn.services;

import java.util.ArrayList;
import java.util.List;

import com.backendlearn.dto.CategoryDto;
import com.backendlearn.entity.Category;
import com.backendlearn.repository.CategoryRepo;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CategoryDto insertCategory(CategoryDto categoryDto) {
		
		Category category=this.modelMapper.map(categoryDto,Category.class);
	
		return this.modelMapper.map((categoryRepo.save(category)),CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) {
		
		Category data=categoryRepo.findById(categoryId).orElseThrow();

        data.setCategoryDescription(categoryDto.getCategoryDescription());
        data.setCategoryTitle(categoryDto.getCategoryTitle());
        
        
        return modelMapper.map(categoryRepo.save(data),CategoryDto.class);
	}

	@Override
	public Integer deleteCategory(Integer categoryId) {
		
		Category data=categoryRepo.findById(categoryId).orElseThrow();
		categoryRepo.deleteById(categoryId);
	
		
		return null;
	}

	@Override
	public List<CategoryDto> getCategories() {

		List<Category> dataModel=categoryRepo.findAll();
		List<CategoryDto> dataDto=new ArrayList<>();
		for(Category cdata:dataModel)
		{
			dataDto.add(modelMapper.map(cdata,CategoryDto.class));
		}
		
		
		return dataDto;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		
      CategoryDto data=modelMapper.map((categoryRepo.findById(categoryId).orElseThrow()),CategoryDto.class);
		
		return data;
		
		
	}

}
