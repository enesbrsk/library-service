package com.example.library.service;

import com.example.library.dto.response.BookListItemResponse;
import com.example.library.dto.request.SaveBookRequest;
import com.example.library.model.Book;
import com.example.library.model.Category;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookSaveService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    @Transactional
    public BookListItemResponse saveBook(SaveBookRequest saveBookRequest){

        Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());

        final Book book = Book.builder()
                .category(category)
                .bookStatus(saveBookRequest.getBookStatus())
                .title(saveBookRequest.getTitle())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .authorName(saveBookRequest.getAuthorName())
                .totalPage(saveBookRequest.getTotalPage())
                .publisher(saveBookRequest.getPublisher())
                .build();

        final Book fromDb = bookRepository.save(book);

        return BookListItemResponse.builder()
                .categoryName(book.getCategory().getName())
                .id(fromDb.getId())
                .bookStatus(fromDb.getBookStatus())
                .publisher(fromDb.getPublisher())
                .authorName(fromDb.getAuthorName())
                .totalPage(fromDb.getTotalPage())
                .title(fromDb.getTitle())
                .lastPageNumber(fromDb.getLastPageNumber()).build();



    }


}
