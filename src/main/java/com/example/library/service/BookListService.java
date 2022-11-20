package com.example.library.service;

import com.example.library.dto.response.BookResponse;
import com.example.library.enums.CategoryType;
import com.example.library.enums.ErrorCode;
import com.example.library.exception.GenericException;
import com.example.library.model.Book;
import com.example.library.enums.BookStatus;
import com.example.library.model.Category;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookListService {

    private final CategoryService categoryService;
    private final BookRepository bookRepository;

    public List<BookResponse> listBooks(int size, int page){
        List<Book> test1 = bookRepository.findAll();
        Page<Book> test = bookRepository.findAll(PageRequest.of(page, size));
        return bookRepository.findAll(PageRequest.of(page,size))
                .getContent()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());

    }

    public BookResponse findBook(Long bookId){

        final Book fromDb = bookRepository.findById(bookId).orElseThrow(() -> GenericException
                .builder().errorCode(ErrorCode.BOOK_NOT_FOUND).build());

        return BookResponse.builder()
                .id(fromDb.getId())
                .bookStatus(fromDb.getBookStatus())
                .publisher(fromDb.getPublisher())
                .authorName(fromDb.getAuthorName())
                .totalPage(fromDb.getTotalPage())
                .lastPageNumber(fromDb.getLastPageNumber())
                .title(fromDb.getTitle())
                .imageUrl(fromDb.getImage() != null ? fromDb.getImage().getImageUrl() : null)
                .build();

    }

    public List<BookResponse> searchByCategory(CategoryType categoryType){

        final Category category = categoryService.findByName(categoryType.getValue());
        return category.getBooks()
                .stream()
                .map(BookListService::convertResponse)
                .collect(Collectors.toList());

    }

    private static BookResponse convertResponse(Book model){
        return BookResponse.builder()
                .authorName(model.getAuthorName())
                .title(model.getTitle())
                .build();
    }

    public List<BookResponse> searchBookStatus(BookStatus bookStatus){

        return bookRepository.findByBookStatus(bookStatus)
                .stream()
                .map(each ->
                    BookResponse.builder()
                            .id(each.getId())
                            .imageUrl(each.getImage().getImageUrl())
                            .build())
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchByTitle(String title){

        return bookRepository.findByTitle(title)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .publisher(each.getPublisher())
                                .build())
                .collect(Collectors.toList());
    }

}
