package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category,Long> , JpaSpecificationExecutor<Category> {
}
