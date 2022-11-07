package com.example.library.dto;

import com.example.library.model.BookStatus;
import com.example.library.model.Image;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;

@Data
public final class SaveBookRequest {


    @NotBlank(message = "title not be empty")
    private String title;
    @NotBlank(message = "title not be author name")
    private String authorName;
    @NotBlank
    private BookStatus bookStatus;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;
    private File image;
    @NotNull
    private Long categoryId;
    @NotNull
    private Integer totalPage;
}
