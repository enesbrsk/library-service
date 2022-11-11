package com.example.library.api;

import com.example.library.dto.BookListItemResponse;
import com.example.library.dto.BookResponse;
import com.example.library.dto.CategoryType;
import com.example.library.dto.SaveBookRequest;
import com.example.library.service.BookListService;
import com.example.library.service.BookSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/book")
@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookListService bookListService;
    private final BookSaveService bookSaveService;

    @PostMapping(name = "/save")
    public ResponseEntity<BookListItemResponse> saveBook(@RequestBody SaveBookRequest request){
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(bookSaveService.saveBook(request));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> listBook(@RequestParam(name = "size") int size,
                                                      @RequestParam(name = "page") int page){

        return ResponseEntity.ok(bookListService.listBooks(size, page));

    }

    @GetMapping("/list/category/{categoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType){
        return ResponseEntity.ok(bookListService.searchByCategory(categoryType));
    }

    @GetMapping("/list/title/{title}")
    public ResponseEntity<List<BookResponse>> listByTitle(@PathVariable String title){
        return ResponseEntity.ok(bookListService.searchByTitle(title));
    }



}
