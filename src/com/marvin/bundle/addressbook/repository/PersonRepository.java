package com.marvin.bundle.addressbook.repository;

import java.util.ArrayList;
import java.util.List;
import com.marvin.bundle.addressbook.model.Person;

public class PersonRepository {
    
    private final List<Person> persons = new ArrayList<>();
    
    public PersonRepository() {
    }
    
    public Person save(Person person) {
        this.persons.add(person);
        return person;
    }
    
    public Person findByEmail(String email) {
        return this.persons.stream()
                .filter(person -> email.equals(person.getEmail()))
                .findFirst().orElse(null);
    }
    
    public List<Person> findAll(){
        return this.persons;
    }
}
