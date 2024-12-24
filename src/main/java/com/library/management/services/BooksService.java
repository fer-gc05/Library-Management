package com.library.management.services;

import com.library.management.models.Books;
import com.library.management.repositories.IBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final IBooksRepository booksRepository;

    @Autowired
    public BooksService(IBooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Books addBooks(Books books) {
        return booksRepository.save(books);
    }

    public Books updateBooks(Books books) {
        return booksRepository.save(books);
    }

    public void deleteBooks(Long id) {
        booksRepository.deleteById(id);
    }


    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    public Optional<Books> getBooksById(Long id) {
        return booksRepository.findById(id);
    }

    public List<Books> getBooksByTitle(String title) {
        return booksRepository.findByTitle(title);
    }

    public List<Books> getBooksByPublisher(String publisher) {
        return booksRepository.findByPublisher(publisher);
    }

    public List<Books> getBooksByPublishedDate(String publishedDate) {
        return booksRepository.findByPublishedDate(publishedDate);
    }

    public List<Books> getBooksByDescription(String description) {
        return booksRepository.findByDescription(description);
    }

    public List<Books> getBooksByPageCount(int pageCount) {
        return booksRepository.findByPageCount(pageCount);
    }


    public List<Books> getBooksByCategories(String categories) {
        return booksRepository.findByCategories(categories);
    }

    public List<Books> getBooksByLanguage(String lenguage) {
        return booksRepository.findByLanguage(lenguage);
    }



}
