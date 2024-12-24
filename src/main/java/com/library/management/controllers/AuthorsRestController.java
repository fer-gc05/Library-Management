package com.library.management.controllers;

import com.library.management.models.Authors;
import com.library.management.services.AuthorsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsRestController {
    private final AuthorsServices authorsServices;

    @Autowired
    public AuthorsRestController(AuthorsServices authorsServices) {
        this.authorsServices = authorsServices;
    }

    @GetMapping(value = "/all", headers = "Accept=application/json")
    public List<Authors> getAuthors() {
        return authorsServices.getAuthors();
    }

    @GetMapping(value = "/byId/{id}", headers = "Accept=application/json")
    public Optional<Authors> getAuthorsById(@PathVariable Long id) {
        return authorsServices.getAuthorsById(id);
    }

    @PostMapping(value = "/add", headers = "Accept=application/json")
    public Authors addAuthors(@RequestBody Authors authors) {
        return authorsServices.addAuthors(authors);
    }

    @PutMapping(value = "/update", headers = "Accept=application/json")
    public Authors updateAuthors(@RequestBody Authors authors) {
        return authorsServices.updateAuthors(authors);
    }

    @DeleteMapping(value = "/delete/{id}", headers = "Accept=application/json")
    public void deleteAuthors(@PathVariable Long id) {
        authorsServices.deleteAuthors(id);
    }
}
