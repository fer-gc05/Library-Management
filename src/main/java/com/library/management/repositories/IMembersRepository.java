package com.library.management.repositories;

import com.library.management.models.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMembersRepository extends JpaRepository<Members, Long> {
    public List<Members> findByFirstName(String firstName);

    public List<Members> findByFirstNameAndLastName(String firstName, String lastName);

    public Optional<Members> findByEmail(String email);

    public List<Members> findByPhone(String phone);
}
