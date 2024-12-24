package com.library.management.repositories;

import com.library.management.models.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAuthorsRepositorie extends JpaRepository<Authors, Long> {

    public List<Authors> findByName(String name);


}
