package com.example.library.service;

import com.example.library.dto.request.BookUpdateRequest;
import com.example.library.dto.response.BookListItemResponse;
import com.example.library.enums.ErrorCode;
import com.example.library.exception.GenericException;
import com.example.library.model.Book;
import com.example.library.model.Image;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookUpdateService {

    private final ImageStoreService imageStoreService;
    private final BookRepository bookRepository;

    @Transactional(rollbackOn = Exception.class)
    public BookListItemResponse updateBook(BookUpdateRequest updateRequest) {
        final Long id = updateRequest.getId();
        final Book book = bookRepository.findById(id).orElseThrow(() -> GenericException.builder().errorCode(ErrorCode.BOOK_NOT_FOUND).build());

        updateAttributes(updateRequest, book);

        if (updateRequest.getImage() != null) {
            imageStoreService.deleteImg(id);
            book.setImage(new Image(imageStoreService.uploadImg(updateRequest.getImage(), id)));
        }

        bookRepository.save(book);

        return BookListItemResponse.from(book);
    }

    private static void updateAttributes(BookUpdateRequest updateRequest, Book book) {
        book.setAuthorName(getOrDefault(updateRequest.getAuthorName(), book.getAuthorName()));
        book.setBookStatus(getOrDefault(updateRequest.getBookStatus(), book.getBookStatus()));
        book.setLastPageNumber(getOrDefault(updateRequest.getLastPageNumber(), book.getLastPageNumber()));
        book.setPublisher(getOrDefault(updateRequest.getPublisher(), book.getPublisher()));
        book.setTitle(getOrDefault(updateRequest.getTitle(), book.getTitle()));
        book.setTotalPage(getOrDefault(updateRequest.getTotalPage(), book.getTotalPage()));
    }

    private static <T> T getOrDefault(T data, T defaultValue) {
        return data == null ? defaultValue : data;
    }
}