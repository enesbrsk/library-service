package com.example.library.dto;

import com.example.library.model.BookStatus;
import com.example.library.model.Image;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@Getter
@SuperBuilder
public final class BookResponse {

    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private Long categoryId;
    private Integer totalPage;
    private String imageUrl;

}
