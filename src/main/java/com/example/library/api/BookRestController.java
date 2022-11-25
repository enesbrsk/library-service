package com.example.library.api;

import com.example.library.dto.response.BookListItemResponse;
import com.example.library.dto.response.BookResponse;
import com.example.library.enums.BookStatus;
import com.example.library.enums.CategoryType;
import com.example.library.dto.request.SaveBookRequest;
import com.example.library.service.BookListService;
import com.example.library.service.BookSaveService;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/book")
@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookListService bookListService;
    private final BookSaveService bookSaveService;
    private final UserService userService;


    @PostMapping("/save")
    public ResponseEntity<BookListItemResponse> saveBook(@Valid @RequestBody SaveBookRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookSaveService.saveBook(request));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> listBook(@RequestParam(name = "size") int size, @RequestParam(name = "page") int page) {
        final Long userID = userService.findUserInContext().getId();
        return ResponseEntity.ok(bookListService.listBooks(size, page, userID));
    }


    @GetMapping("/search/{categoryType}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable CategoryType categoryType) {
        final Long userID = userService.findUserInContext().getId();
        return ResponseEntity.ok(this.bookListService.searchByCategory(categoryType, userID));
    }


    @GetMapping("/{status}")
    public ResponseEntity<List<BookResponse>> listByCategory(@PathVariable BookStatus status) {
        final Long userID = userService.findUserInContext().getId();
        return ResponseEntity.ok(this.bookListService.searchBookStatus(status, userID));
    }

    @GetMapping("/list/{title}")
    public ResponseEntity<List<BookResponse>> listByTitle(@PathVariable String title) {
        return ResponseEntity.ok(this.bookListService.searchByTitle(title));
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookSaveService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<BookResponse> searchBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookListService.findBook(bookId));
    }

}
