package com.example.library.dto;

import com.example.library.model.BookStatus;
import com.example.library.model.Image;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.io.File;

@Data
@SuperBuilder
public final class BookListItemResponse {

    private Long id;
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private File image;
    private String categoryName;
    private Integer totalPage;

}
