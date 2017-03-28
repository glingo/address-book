package com.marvin.bundle.addressbook.business;

import java.util.List;
import com.marvin.bundle.addressbook.model.Person;
import com.marvin.bundle.addressbook.repository.PersonRepository;

public class PersonManager {
    
    private PersonRepository repository;
    
    public PersonManager(PersonRepository repository) {
        this.repository = repository;
    }
    
    public Person getByEmail(String email) {
        assert email != null;
        
        return repository.findByEmail(email);
    }
    
    public Person save(Person person) {
        assert person != null;
        assert person.getEmail() != null;
        
        return this.repository.save(person);
    }
    
    public List<Person> getAll() {
        return this.repository.findAll();
    }
}
