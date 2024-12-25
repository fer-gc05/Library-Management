package com.library.management.controllers.google.books.api;

import com.library.management.models.google.books.api.BookApi;
import com.library.management.services.google.books.api.BookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/get/books")
public class BookApiRestController {

    private BookApiService bookApiService;

    @Autowired
    public BookApiRestController(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
    }

    @GetMapping(value = "/search", headers = "Accept=application/json")
    public List<BookApi> searchBooks(@RequestParam String title) {
        try {
            return bookApiService.searchBooks(title);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar libros: " + e.getMessage());
        }
    }
}
