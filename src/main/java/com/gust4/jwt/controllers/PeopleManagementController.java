package com.gust4.jwt.controllers;

import com.gust4.jwt.model.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/management/people")
public class PeopleManagementController {

    private static final List<Person> PEOPLE = Arrays.asList(
            new Person(1L, "gusta"),
            new Person(2L, "carlos"),
            new Person(3L, "João")
    );

//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permissions')

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Person> getAllPeople() {return PEOPLE;}

    @PostMapping("/new")
    @PreAuthorize("hasAuthority('person:write')")
    public void insertNewPerson(@RequestBody Person person) {System.out.println(person);}

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('person:write')")
    public void deletePerson(@PathVariable("id") Long id) {System.out.println(id);}

}
