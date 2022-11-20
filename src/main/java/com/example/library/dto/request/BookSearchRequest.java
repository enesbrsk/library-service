package com.example.library.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class BookSearchRequest {
    private int size;
    private int page;
}
