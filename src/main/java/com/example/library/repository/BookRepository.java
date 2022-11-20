package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Long> , JpaSpecificationExecutor<Book> {

    List<Book> findByBookStatus(BookStatus bookStatus);
    List<Book> findByTitle(String title);

}
