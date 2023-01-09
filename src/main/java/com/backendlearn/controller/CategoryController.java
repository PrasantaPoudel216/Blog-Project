package com.backendlearn.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.backendlearn.dto.CategoryDto;
import com.backendlearn.payloads.Response;
import com.backendlearn.services.CategoryService;
import com.backendlearn.utils.UsersMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/category/")
public class CategoryController implements UsersMessage {

	@Autowired
	CategoryService categoryService;

	// INsert
@RequestMapping(value="/insertcategory",method=RequestMethod.POST)
	public Response insertCategory(@RequestBody CategoryDto categoryDto) {
		Response response = new Response();
		response.setObject(categoryService.insertCategory(categoryDto));
		response.setMessage(DATA_SAVED);
		response.setState(true);

		return response;
	}

	// update
@PutMapping(value="/updatecategory/{categoryId}")
	public Response updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId) {
		Response response = new Response();
		response.setObject(categoryService.updateCategory(categoryDto, categoryId));
		response.setMessage(DATA_UPDATED);
		response.setState(true);

		return response;

	}

	/// get all
@GetMapping(value="/getcategories")
public Response getAllCategory()
{
	Response response=new Response();
	List<CategoryDto>categoryLists=categoryService.getCategories();
	
	response.setMessage(DATA_FOUND);
	response.setObject(categoryLists);
	response.setState(true);
	
	return response;
	
}
	// get by id
@GetMapping(value="/getcategorybyid/{categoryId}")
public Response getCategoryById(@PathVariable Integer categoryId)
{
	Response response=new Response();
	
	response.setMessage(DATA_FOUND);
	response.setObject(categoryService.getCategoryById(categoryId));
	response.setState(true);
	
	return response;
	
}

	// delete
@RequestMapping(value="/deletecategory",method=RequestMethod.DELETE)
public Response deleteCategory(@PathVariable Integer categoryId)
{
	Response response =new Response();
	categoryService.deleteCategory(categoryId);
	response.setMessage(DATA_DELETED);
	response.setState(true);
	
	return response;
}

}
