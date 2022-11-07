package com.example.library.service;

import com.example.library.dto.BookResponse;
import com.example.library.dto.BookSearchRequest;
import com.example.library.repository.BookRepository;
import com.example.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookListService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public List<BookResponse> listBooks(BookSearchRequest searchRequest){

        return bookRepository.findAll(PageRequest.of(searchRequest.getPage(),searchRequest.getSize()))
                .getContent()
                .stream()
                .map(model ->
                    BookResponse.builder()
                            .authorName(model.getAuthorName())
                            .title(model.getTitle())
                            .imageUrl(model.getImage().getImageUrl())
                            .build()).collect(Collectors.toList());

    }


}
