package com.library.management.services;

import com.library.management.models.Authors;
import com.library.management.repositories.IAuthorsRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsServices {
    private final IAuthorsRepositorie authorsRepositorie;

    @Autowired
    public AuthorsServices(IAuthorsRepositorie authorsRepositorie) {
        this.authorsRepositorie = authorsRepositorie;
    }
    public Authors addAuthors(Authors authors) {
        return authorsRepositorie.save(authors);
    }

    public Authors updateAuthors(Authors authors) {
        return authorsRepositorie.save(authors);
    }

    public void deleteAuthors(Long id) {
        authorsRepositorie.deleteById(id);
    }

    public List<Authors> getAuthors() {
        return authorsRepositorie.findAll();
    }

    public Optional<Authors> getAuthorsById(Long id) {
        return authorsRepositorie.findById(id);
    }

}
