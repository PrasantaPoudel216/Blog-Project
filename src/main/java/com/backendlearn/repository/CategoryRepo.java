package com.backendlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendlearn.entity.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
