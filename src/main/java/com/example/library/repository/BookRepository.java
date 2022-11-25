package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> , JpaSpecificationExecutor<Book> {

    Optional<Book> findByTitle(String title);
}
