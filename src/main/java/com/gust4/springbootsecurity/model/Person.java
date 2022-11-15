package com.gust4.springbootsecurity.model;

import java.util.*;

public class Person {

    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person people = (Person) o;
        return id.equals(people.id) && name.equals(people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
