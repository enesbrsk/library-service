package com.example.library.service;

import com.example.library.enums.ErrorCode;
import com.example.library.exception.GenericException;
import com.example.library.model.Category;
import com.example.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public Category loadCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> GenericException.builder().errorCode(ErrorCode.CATEGORY_NOT_FOUND).build());
    }

    public Category findByName(String value) {
        return categoryRepository.findByName(value).orElseThrow(() -> GenericException.builder().errorCode(ErrorCode.CATEGORY_NOT_FOUND).build());
    }
}
