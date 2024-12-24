package com.library.management.services;

import com.library.management.models.Members;
import com.library.management.repositories.IMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembersService {
    private final IMembersRepository membersRepository;

    @Autowired
    public MembersService(IMembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    public Optional<Members> getMembersById(Long id) {
        return membersRepository.findById(id);
    }

    public Members addMembers(Members members) {
        return membersRepository.save(members);
    }

    public Members updateMembers(Members members) {
        return membersRepository.save(members);
    }

    public void deleteMembers(Long id) {
        membersRepository.deleteById(id);
    }

    public List<Members> getMembersByFirstName(String firstName) {
        return membersRepository.findByFirstName(firstName);
    }

    public List<Members> getMembersByFirstNameAndLastName(String firstName, String lastName) {
        return membersRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Members> getMembersByPhoneNumber(String phoneNumber) {
        return membersRepository.findByPhone(phoneNumber);
    }

    public Optional<Members> getMembersByEmail(String email) {
        return membersRepository.findByEmail(email);
    }
}
