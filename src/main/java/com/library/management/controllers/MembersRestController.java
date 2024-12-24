package com.library.management.controllers;

import com.library.management.models.Members;
import com.library.management.services.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/members")
public class MembersRestController {

    private final MembersService membersService;

    @Autowired
    public MembersRestController(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping(value = "/all", headers = "Accept=application/json")
    public List<Members> getMembers() {
        return membersService.getAllMembers();
    }

    @GetMapping(value = "/byFirstName/{firstName}", headers = "Accept=application/json")
    public List<Members> getMembersByFirstName(@PathVariable String firstName) {
        return membersService.getMembersByFirstName(firstName);
    }

    @GetMapping(value = "/byFirstNameAndLastName/{firstName}/{lastName}", headers = "Accept=application/json")
    public List<Members> getMembersByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return membersService.getMembersByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping(value = "/byPhoneNumber/{phoneNumber}", headers = "Accept=application/json")
    public List<Members> getMembersByPhoneNumber(@PathVariable String phoneNumber) {
        return membersService.getMembersByPhoneNumber(phoneNumber);
    }

    @GetMapping(value = "/byEmail/{email}", headers = "Accept=application/json")
    public Optional<Members> getMembersByEmail(@PathVariable String email) {
        return membersService.getMembersByEmail(email);
    }

    @GetMapping(value = "/byId/{id}", headers = "Accept=application/json")
    public Optional<Members> getMembersById(@PathVariable Long id) {
        return membersService.getMembersById(id);
    }

    @PutMapping(value = "/update", headers = "Accept=application/json")
    public Members updateMembers(@RequestBody Members members) {
        return membersService.updateMembers(members);
    }

    @PostMapping(value = "/add", headers = "Accept=application/json")
    public Members addMembers(@RequestBody Members members) {
        return membersService.addMembers(members);
    }

    @DeleteMapping(value = "/delete/{id}", headers = "Accept=application/json")
    public void deleteMembers(@PathVariable Long id) {
        membersService.deleteMembers(id);
    }

}
