package com.library.management.repositories;

import com.library.management.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBooksRepository extends JpaRepository<Books, Long> {

    public List<Books> findByTitle(String title);

    public List<Books> findByPublisher(String publisher);

    public List<Books> findByPublishedDate(String publishedDate);

    public List<Books> findByDescription(String description);

    public List<Books> findByPageCount(int pageCount);

    public List<Books> findByCategories(String categories);

    public List<Books> findByLanguage(String language);



}
