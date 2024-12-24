package com.library.management.controllers;

import com.library.management.models.Books;
import com.library.management.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BooksRestController {
    private final BooksService booksService;

    @Autowired
    public BooksRestController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping(value = "/all", headers = "Accept=application/json")
    public List<Books> getBooks() {
        return booksService.getBooks();
    }

    @PostMapping(value = "/add", headers = "Accept=application/json")
    public Books addBooks(@RequestBody Books books) {
        return booksService.addBooks(books);
    }

    @PutMapping(value = "/update", headers = "Accept=application/json")
    public Books updateBooks(@RequestBody Books books) {
        return booksService.updateBooks(books);
    }

    @DeleteMapping(value = "/delete/{id}", headers = "Accept=application/json")
    public void deleteBooks(@PathVariable Long id) {
        booksService.deleteBooks(id);
    }

    @GetMapping(value = "/byId/{id}", headers = "Accept=application/json")
    public Optional<Books> getBooksById(@RequestBody Long id) {
        return booksService.getBooksById(id);
    }

    @GetMapping(value = "/byTitle/{title}", headers = "Accept=application/json")
    public List<Books> getBooksByTitle(@PathVariable String title) {
        return booksService.getBooksByTitle(title);
    }

    @GetMapping(value = "/byPublisher/{publisher}", headers = "Accept=application/json")
    public List<Books> getBooksByPublisher(@PathVariable String publisher) {
        return booksService.getBooksByPublisher(publisher);
    }

    @GetMapping(value = "/byPublishedDate/{publishedDate}", headers = "Accept=application/json")
    public List<Books> getBooksByPublishedDate(@PathVariable String publishedDate) {
        return booksService.getBooksByPublishedDate(publishedDate);
    }

    @GetMapping(value = "/byDescription/{description}", headers = "Accept=application/json")
    public List<Books> getBooksByDescription(@PathVariable String description) {
        return booksService.getBooksByDescription(description);
    }

    @GetMapping(value = "/byPageCount/{pageCount}", headers = "Accept=application/json")
    public List<Books> getBooksByPageCount(@PathVariable int pageCount) {
        return booksService.getBooksByPageCount(pageCount);
    }

    @GetMapping(value = "/byCategories/{categories}", headers = "Accept=application/json")
    public List<Books> getBooksByCategories(@PathVariable String categories) {
        return booksService.getBooksByCategories(categories);
    }

    @GetMapping(value = "/byLenguage/{language}", headers = "Accept=application/json")
    public List<Books> getBooksByLenguage(@PathVariable String language) {
        return booksService.getBooksByLanguage(language);
    }
}
