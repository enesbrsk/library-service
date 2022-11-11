package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.BookStatus;
import com.example.library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book,Long> , JpaSpecificationExecutor<Book> {

    List<Book> findByBookStatus(BookStatus bookStatus);
    List<Book> findByTitle(String title);

}
